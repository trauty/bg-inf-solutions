import socketio.*;

import java.io.IOException;
import java.util.Scanner;

public class Client
{
    Client() throws IOException
    {
        Socket server = new Socket("localhost", 42060);
        server.connect();
        server.write("Hallo Server\n");
        System.out.println(server.readLine());

        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            String outBuf = scanner.nextLine();
            server.write(outBuf + "\n");

            String inBuf;

            inBuf = server.readLine();
            if (inBuf.equals("OK: Bye"))
            {
                break;
            }
            /*else if (inBuf.contains("Das Ergebnis lautet:"))
            {
                inBuf += server.readLine();
            }*/
            else
            {
                System.out.println(inBuf);
            }
        }

        server.close();
    }

    public static void main(String[] args)
    {
        try
        {
            new Client();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
        }
    }
}
