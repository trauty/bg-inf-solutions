import serialio.Serial;
import java.util.*;

public class ReceiveThread implements Runnable
{
	final int ACK = 0x06;
	final int ETX = 0x03;
	int ch;
	Serial comm;
	public ReceiveThread(Serial comm)
	{
		this.comm = comm;
	}

	@Override
	public synchronized void run()
	{
		try
		{
			comm.write(ACK);
			System.out.println("Empfange Text:");
			while ((ch = comm.read()) != ETX)
				System.out.print((char)ch);
			comm.write(ACK);
			System.out.println("Uebertragung beendet.");
			comm.close();
		}
		catch (Exception e)
		{
			System.err.println("Fehler: " + e.getMessage());
		}
	}
}
