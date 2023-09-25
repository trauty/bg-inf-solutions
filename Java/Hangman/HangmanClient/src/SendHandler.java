import socketio.Socket;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.Thread.*;

public class SendHandler implements Runnable
{
    private final Socket socket;

    public SendHandler(Socket socket)
    {
        this.socket = socket;
    }
    @Override
    public void run()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Bitte Namen eingeben: ");

        try
        {
            socket.write(input.nextLine() + "\n");
            while (!interrupted())
            {
                socket.write(input.nextLine() + "\n");
            }
        }
        catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }
}