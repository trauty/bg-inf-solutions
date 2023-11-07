import socketio.Socket;

import java.io.IOException;

public class Main
{
    public Main(String endpoint, int port) throws IOException
    {
        try
        {
            Socket socket = new Socket(endpoint, port);
            socket.connect();
            socket.write("Hi Server!\n");

            System.out.println(socket.readLine());

            socket.close();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException
    {
        new Main("localhost", 18888);
    }
}