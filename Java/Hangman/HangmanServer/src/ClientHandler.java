import socketio.Socket;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

import static java.lang.Thread.interrupted;

public class ClientHandler implements Runnable
{
    public volatile static char[] state;
    public static AtomicBoolean hasGameBegun = new AtomicBoolean(false);
    public volatile static String wordToGuess = "";
    public static volatile int guesserID;
    public static AtomicInteger remainingTries = new AtomicInteger();
    public static AtomicInteger counter = new AtomicInteger();
    //public volatile static String wordToGuess = "";

    private final Integer id;

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
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public void startGame() throws IOException
    {
        clientSocket.write("Du bist der Host!\nGib das unbekannte Wort ein: \n");
        wordToGuess = clientSocket.readLine();
        state = new char[wordToGuess.length()];
        Arrays.fill(state, '_');
        guesserID = getIDAt(0);
        remainingTries.set(10);
        hasGameBegun.set(true);
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println(clientName);

            if (id.equals(0))
            {
                startGame();
            }

            while (!interrupted())
            {
                if (hasGameBegun.get() && id.equals(guesserID))
                {
                    for (ClientHandler handler : Server.clientHandlers.values())
                    {
                        handler.clientBroadcast(
                                String.valueOf(state) +
                                "\nVerbleibende Fehler: " + remainingTries +
                                "\n'" + clientName + "' ist dran.\n" +
                                        "from: " + id + "\n"
                        );
                    }

                    char guessChar = clientSocket.readLine().toLowerCase().charAt(0);
                    boolean foundChar = false;

                    for (int i = 0; i < wordToGuess.length(); i++)
                    {
                        if (wordToGuess.toLowerCase().charAt(i) == guessChar)
                        {
                            state[i] = wordToGuess.charAt(i);
                            foundChar = true;
                        }
                    }

                    if (!foundChar) { remainingTries.decrementAndGet(); }

                    if (remainingTries.get() == 0)
                    {
                        for (ClientHandler handler : Server.clientHandlers.values())
                        {
                            handler.clientBroadcast(
                                    "Leider verloren!\n" +
                                            "Das Wort war '" + wordToGuess + "'!\n" +
                                            ((handler.getID() == 0) ? "Noch eine Runde? j/n\n" :
                                                    "Warte auf Host.\n")
                            );
                        }

                        hasGameBegun.set(false);

                        ClientHandler hostHandler = Server.clientHandlers.get(0);

                        if(hostHandler.getClientSocket().readLine().toLowerCase().charAt(0) == 'j')
                        {
                            hostHandler.startGame();
                        }
                        else
                        {
                            System.out.println("SERVER SHUTDOWN");
                            System.exit(0);
                        }
                    }

                    if (String.valueOf(state).equals(wordToGuess))
                    {
                        for (ClientHandler handler : Server.clientHandlers.values())
                        {
                            handler.clientBroadcast(
                                    "Gewonnen!\n" +
                                            "Das Wort ist '" + wordToGuess + "'!\n" +
                                            ((handler.getID() == 0) ? "Noch eine Runde? j/n\n" :
                                                    "Warte auf Host.\n")
                            );
                        }

                        hasGameBegun.set(false);

                        ClientHandler hostHandler = Server.clientHandlers.get(0);

                        if(hostHandler.getClientSocket().readLine().toLowerCase().charAt(0) == 'j')
                        {
                            hostHandler.startGame();
                        }
                        else
                        {
                            System.out.println("SERVER SHUTDOWN");
                            System.exit(0);
                        }
                    }
                    int crtID = counter.incrementAndGet();
                    if (crtID == Server.clientHandlers.size())
                    {
                        counter.set(0);
                    }
                    guesserID = getIDAt(counter.get());
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

    public Socket getClientSocket()
    {
        return clientSocket;
    }

    public int getID()
    {
        return id;
    }

    public int getIDAt(int index)
    {
        Set<Integer> keys = Server.clientHandlers.keySet();
        Integer[] temp = keys.toArray(new Integer[keys.size()]);
        return temp[index];
    }
}
