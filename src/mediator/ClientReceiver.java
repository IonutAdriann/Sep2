package mediator;

import java.io.BufferedReader;

public class ClientReceiver implements Runnable
{
    private BufferedReader in;
    private GymClient client;

    public ClientReceiver(GymClient gymClient, BufferedReader in)
    {
        this.in = in;
        this.client= gymClient;
    }

    @Override
    public void run() {
        while(true) {
            try {
                String serverReply =in.readLine();
                client.receive(serverReply);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
