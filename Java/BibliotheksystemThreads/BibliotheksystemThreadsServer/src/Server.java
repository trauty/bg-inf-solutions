import socketio.*;

import java.io.IOException;

// nicht fertig

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket socket = new ServerSocket(42060);
        Bibliothekssystem sys = new Bibliothekssystem();


        while (true)
        {
            Socket crtClient = socket.accept();

            new Thread(new AnfrageThread(crtClient, sys));
        }
    }
}
