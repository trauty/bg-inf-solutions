import socketio.Socket;

import java.io.IOException;

public class Main
{
    public Main() throws IOException
    {
        Socket client = new Socket("localhost", 42060);
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
