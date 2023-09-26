import socketio.Socket;

import java.io.IOException;

import static java.lang.Thread.interrupted;

public class ReceiveHandler implements Runnable
{
    private final Socket socket;

    private String currentMsg = "";

    public ReceiveHandler(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run()
    {
        try
        {
            while (!interrupted())
            {
                currentMsg = socket.readLine();
                System.out.println(currentMsg);
            }
        }
        catch (IOException exc)
        {
            System.exit(0);
        }
    }
}