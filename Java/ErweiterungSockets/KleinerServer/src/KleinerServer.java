import socketio.*;

import java.io.IOException;

public class KleinerServer
{
    ServerSocket server = new ServerSocket(42060);

    public KleinerServer() throws IOException
    {
        int sumCount = 0;

        Socket client = server.accept();
        client.write("Hallo Client\n");
        System.out.println(client.readLine());
        String outBuf = "";

        int summand1 = 0, summand2;

        boolean interactionStarted = false;

        while(true)
        {
            String currentPacket = client.readLine();
            System.out.println(currentPacket);

            if (currentPacket.equals("Start") && !interactionStarted)
            {
                outBuf = "Bitte ersten Summanden schicken\n";
                interactionStarted = true;
            }

            else if (isNum(currentPacket) && sumCount == 0 && interactionStarted)
            {
                summand1 = Integer.parseInt(currentPacket);
                System.out.println(summand1);
                outBuf = "Bitte zweiten Summanden schicken\n";
                sumCount++;
            }
            else
            {
                outBuf = "Error: Bitte ersten Summanden schicken\n";
            }

            if (isNum(currentPacket) && sumCount == 1)
            {
                summand2 = Integer.parseInt(currentPacket);
                outBuf = "Das Ergebnis lautet: " + (summand1 + summand2) + " || " +
                        "Nochmal rechnen? J/N\n";
                sumCount++;
            }

            client.write(outBuf);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            new KleinerServer();
        }
        catch (IOException exc)
        {
            System.out.println(exc);
        }
    }

    private static boolean isNum(String numStr)
    {
        if (numStr == null) { return false; }
        try
        {
            Double.parseDouble(numStr);
        }
        catch (NumberFormatException exc)
        {
            return false;
        }
        return true;
    }
}
