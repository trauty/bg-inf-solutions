import serialio.Serial;

import java.util.Scanner;

public class SendThread implements Runnable
{
    final int ACK = 0x06;
    final int ETX = 0x03;
    String name = "";
    Serial comm;
    Scanner sc = new Scanner(System.in);
    public SendThread(Serial comm, String name)
    {
        this.comm = comm;
        this.name = name;
    }
    @Override
    public synchronized void run()
    {
        try
        {
            System.out.println("Sender gestartet!");
            while (true)
            {
                String text = sc.nextLine();
                comm.write(name + ": " + text);
                comm.write(ETX);
            }
        }
        catch (Exception e)
        {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}
