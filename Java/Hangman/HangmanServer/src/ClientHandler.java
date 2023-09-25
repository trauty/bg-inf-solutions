import socketio.Socket;

import java.io.IOException;

import static java.lang.Thread.interrupted;

public class ClientHandler implements Runnable
{
    public volatile static String state = "";
    public volatile static String wordToGuess = "";
    public volatile static int guesserID;
    public volatile static int remainingTries = 10;
    //public volatile static String wordToGuess = "";

    private final int id;

    private final String clientName;

    private final Socket clientSocket;

    public ClientHandler(Socket currentClientSocket, int id, String clientName)
    {
        this.clientSocket = currentClientSocket;
        this.id = id;
        this.clientName = clientName;
    }

    public void clientBroadcast(String msg) throws IOException
    {
        try
        {
            clientSocket.write(msg);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(clientName);

            if (id == 0)
            {
                clientSocket.write("Du bist der Host!\nGib das unbekannte Word ein: \n");
                wordToGuess = clientSocket.readLine();
                guesserID = id;
            }

            while (!interrupted())
            {
                if (Server.hasGameBegun && guesserID == id)
                {
                    for (ClientHandler handler : Server.clientHandlers.values())
                    {
                        handler.clientBroadcast(

                                "Verbleibende Versuche: " + remainingTries +
                                "\n'" + clientName + "' ist dran.\n"
                        );
                    }
                }
            }
        }
        catch (IOException exc)
        {
            try
            {
                Server.clientHandlers.remove(id);

                for (ClientHandler handler : Server.clientHandlers.values())
                {
                    handler.clientBroadcast("Spieler '" + clientName + "' mit der ID " +
                            id + " hat das Spiel verlassen\n");
                }
            }
            catch (IOException e)
            {
                System.out.println("Error: Problem beim entfernen des Spielers mit ID: " + id + "\n");
            }
        }
    }

    public void stop()
    {
        interrupted();
    }
}
