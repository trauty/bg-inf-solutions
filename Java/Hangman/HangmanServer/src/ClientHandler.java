import socketio.Socket;

import java.io.IOException;

public class ClientHandler implements Runnable
{
    private final Socket clientSocket;
    private final int id;

    public ClientHandler(Socket currentClientSocket, int id)
    {
        this.clientSocket = currentClientSocket;
        this.id = id;
    }

    @Override
    public void run()
    {
        try
        {
            System.out.println("Thread started with ID: " + id);
            clientSocket.write("I AM A CLIENT THREAD, ID: " + id + "\n");
            Main.clientThreads.remove(id);
            Thread.sleep(500);
            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
    }
}
