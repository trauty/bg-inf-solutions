import socketio.Socket;

import java.io.IOException;

public class Main
{
    public Main() throws IOException
    {
        Socket client = new Socket("localhost", 42060);
        client.connect();
        System.out.println(client.readLine());
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
