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
        boolean calcDone = false;

        while(true) // Dieser Code ist katastrophal
        {
            String currentPacket = client.readLine();
            System.out.println(currentPacket);

            if ((currentPacket.equals("Start") || calcDone) && !interactionStarted)
            {
                outBuf = "Bitte ersten Summanden schicken\n";
                interactionStarted = true;
            }
            else if (sumCount == 0)
            {
                outBuf = "Rechner nicht gestartet!\n";
            }

            if (isNum(currentPacket) && sumCount == 0 && interactionStarted)
            {
                summand1 = Integer.parseInt(currentPacket);
                System.out.println(summand1);
                outBuf = "Bitte zweiten Summanden schicken\n";
                sumCount++;
            }
            else if (!currentPacket.equals("Start") && sumCount == 0 && interactionStarted)
            {
                outBuf = "Error: Bitte ersten Summanden schicken\n";
            }
            else if (!currentPacket.equals("Start") && !isNum(currentPacket) && sumCount == 1)
            {
                outBuf = "Error: Bitte zweiten Summanden schicken\n";
            }
            else if (isNum(currentPacket) && sumCount == 1)
            {
                summand2 = Integer.parseInt(currentPacket);
                outBuf = "Das Ergebnis lautet: " + (summand1 + summand2) + " || " +
                        "Nochmal rechnen? J/N\n";
                sumCount++;
            }

            if (sumCount == 2 && !isNum(currentPacket))
            {
                if (currentPacket.equals("J"))
                {
                    calcDone = true;
                    sumCount = 0;
                    outBuf = "Bitte ersten Summanden schicken\n";
                }
                else if (currentPacket.equals("N"))
                {
                    outBuf = "OK: Bye\n";
                    client.write(outBuf);
                    break;
                }
                else
                {
                    outBuf = "Keine moegliche Antwort ausgewaehlt\n";
                }
            }

            client.write(outBuf);
        }

        client.close();
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
