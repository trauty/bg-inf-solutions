import socketio.*;

import java.io.IOException;

public class Client
{
    Client() throws IOException
    {
        Socket server = new Socket("10.62.3.5", 18769);
        server.connect();
        server.write(5);
        server.write(10);
        System.out.println(server.read());
        server.close();
    }

    public static void main(String[] args)
    {
        try
        {
            Client client = new Client();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
        }
    }
}
