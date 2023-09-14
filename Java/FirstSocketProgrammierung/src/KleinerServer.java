
import socketio.*;

import java.io.IOException;

public class KleinerServer
{
    ServerSocket server = new ServerSocket(18769);

    public KleinerServer() throws IOException
    {
        while(true)
        {
            Socket client = server.accept();
            int zahl1 = client.read();
            int zahl2 = client.read();

            client.write(zahl1 + zahl2);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            KleinerServer server = new KleinerServer();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
        }
    }
}
