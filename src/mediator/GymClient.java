package mediator;

import Model.*;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GymClient implements ServerModel {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private Model model;
    private Gson gson;
    private ClientReceiver clientReceiver;

    public GymClient(String host, int port, Model model) {
        try {
            socket = new Socket(host, port);
            this.model = model;
            this.gson = new Gson();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            clientReceiver = new ClientReceiver(this, in);
        } catch (Exception e){

        }
    }

    public void receive(String string) throws IOException {
        Message message =gson.fromJson(string, Message.class);
        switch (message.getTypeOfMessage()) {
            case "Gym_Loading" :
                Asset asset = gson.fromJson(message.getMessage(), Asset.class);
                model.loadAssetsToGym(asset);
                break;

            case "Alarm" :
                model.fireProperty("Window Alarm", message.getMessage());
                model.fireProperty("Notification", message.getMessage());
                break;

            case "Notification" :
                model.fireProperty("Notification", message.getMessage());
                break;

            case "UserList_Loading" :
                model.getListOfUsers().getUsers().addAll(message.getClients());
                model.getListOfUsers().getUsers().addAll(message.getAdministrators());
                break;
        }
    }

    @Override public boolean Login(String username, String password) {
        out.println("Login");
        out.println(username);
        out.println(password);

        try {
            String readLine = in.readLine();
            Message message =gson.fromJson(readLine, Message.class);

            if(message.getTypeOfMessage().equals("Message")){
                if (message.getMessage().equals("Login Verified")){
                    if(message.getUser().isAdmin()){
                        model.setAdmin((Admin) message.getUser());
                    } else {
                        model.setClient((Client) message.getUser());
                    }
                    Thread thread1 =new Thread (clientReceiver, " ");
                    thread1.start();
                    out.println("Gym_inventory_loading");
                    out.println("notifications_loading");
                    out.println("UserList_loading");
                    model.getInventoryUser().getAssets().addAll(message.getUser().getInventoryUser().getAssets());
                    return true;
                } else if(message.getMessage().equals("Wrong_Username")) {
                    model.setErrorLabel("Wrong_Username");
                } else if(message.getMessage().equals("Wrong_Password")) {
                    model.setErrorLabel("Wrong_Password");
                }
            }
        } catch(Exception e) {
            return false;
        }
        return false;
    }

    @Override public void Register(UserType User) {
        out.println("Registering");
        String RegisteringGymUser = gson.ToJson(User);
        out.println(RegisteringGymUser);
    }


    @Override public void borrowAsset(String id) {
        out.println("Borrow_Asset");
        out.println(id);
        out.println(model.getUsername());
    }

    @Override public void returnAsset(String id) {
        out.println("Return_Asset");
        out.println(id);
        out.println(model.getUsername());
    }

    @Override
    public void rateAsset(String id, String username, int rating1) {

    }

    @Override
    public void removeAsset(String id) {

    }

    @Override
    public void addAssetToGymServer(Asset asset) {
        out.println("Add_Asset");
        String adding = gson.ToJson(asset);
        out.println(adding);
    }
}
