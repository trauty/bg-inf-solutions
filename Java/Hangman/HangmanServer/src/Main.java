import socketio.ServerSocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Main
{
    public static ConcurrentHashMap<Integer, Thread> clientThreads = new ConcurrentHashMap<>();

    public Main() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(42060);

        int currentID = 0;

        while (true)
        {
            Thread newClientThread = new Thread(new ClientHandler(serverSocket.accept(), currentID));
            clientThreads.put(currentID, newClientThread);
            newClientThread.start();
            currentID++;
        }
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
