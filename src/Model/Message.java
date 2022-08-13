package Model;

import java.util.ArrayList;

public class Message<T>{
    private String message;
    private Admin admin;
    private Client client;
    private String typeOfMessage;
    private ArrayList<Client> clients;
    private ArrayList<Admin> admins;

    public Message(String message, String typeOfMessage) {
        this.message = message;
        this.typeOfMessage = typeOfMessage;
        this.admins = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void setMessage(String message) {this.message = message;}

    public String getMessage() {return message;}

    public String getTypeOfMessage(){return typeOfMessage;}

    public UserType getUser() {
        if(client != null) {
            return client;
        }
        else {
            return admin;
        }
    }

    public void setClient(Client client1) {this.client = client1;}

    public void setAdmin(Admin admin1) {this.admin = admin1;}

    public void addAdmin(Admin admin) {admins.add(admin);}

    public void AddClient(Client client) {clients.add(client);}

    public ArrayList<Client> getClients() {return clients;}

    public ArrayList<Admin> getAdministrators(){return admins;}
}
