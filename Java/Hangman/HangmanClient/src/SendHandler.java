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
            while (!interrupted())
            {
                String nextLine = input.nextLine();

                if (!nextLine.isEmpty())
                {
                    socket.write(nextLine + "\n");
                }
            }
        }
        catch (IOException exc)
        {
            System.exit(0);
        }
    }
}