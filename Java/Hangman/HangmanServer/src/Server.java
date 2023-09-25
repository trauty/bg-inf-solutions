import socketio.ServerSocket;
import socketio.Socket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Server
{
    public static ConcurrentHashMap<Integer, ClientHandler> clientHandlers = new ConcurrentHashMap<>();

    public static boolean hasGameBegun = false;

    public Server() throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(42060);

        int currentID = 0;

        while (true)
        {
            Socket newClientSocket = serverSocket.accept();
            String clientName = newClientSocket.readLine();

            ClientHandler curHandler = new ClientHandler(newClientSocket, currentID, clientName);
            Thread newClientThread = new Thread(curHandler);
            clientHandlers.put(currentID, curHandler);
            newClientThread.start();

            if (currentID > 0)
            {
                for (ClientHandler handler : clientHandlers.values())
                {
                    handler.clientBroadcast("UPDATE: Es sind derzeit " +
                            clientHandlers.size() + " Spieler in der Lobby.\n");
                }
            }

            currentID++;
        }
    }

    public static void main(String[] args)
    {
        try
        {
            new Server();
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
