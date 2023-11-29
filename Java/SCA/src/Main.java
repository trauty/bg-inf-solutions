import serialio.Serial;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String serialPort = "";
        int baudrate = 0;
        String name = "";

        try
        {
            System.out.println("COM-Port: ");
            serialPort = sc.nextLine();
            System.out.println("Baudrate: ");
            baudrate = Integer.parseInt(sc.nextLine());
            System.out.println("Name: ");
            name = sc.nextLine();
            name = name.replace("\n", "");

            Serial comm = new Serial(serialPort, baudrate,
                    Serial.DATABITS_8,
                    Serial.STOPBITS_1,
                    Serial.PARITY_NONE);

            if (!comm.open()) { throw new Exception(); }


            Thread receiveThread = new Thread(new ReceiveThread(comm));
            receiveThread.start();

            Thread sendThread = new Thread(new SendThread(comm, name));
            sendThread.start();
        }
        catch (Exception e)
        {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}