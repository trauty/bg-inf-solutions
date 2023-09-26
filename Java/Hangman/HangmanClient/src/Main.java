import socketio.Socket;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public Main() throws IOException
    {
        System.out.println("IP: ");
        Scanner input = new Scanner(System.in);
        String ip = input.nextLine();
        Socket client = new Socket(ip, 42060);
        client.connect();

        Thread sendHandler = new Thread(new SendHandler(client));
        sendHandler.start();
        Thread receiveHandler = new Thread(new ReceiveHandler(client));
        receiveHandler.start();
    }

    public static void main(String[] args)
    {
        try
        {
            new Main();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
