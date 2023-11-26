
import serialio.Serial;
import java.util.*;

public class SendText {

	// Sendererseite (muss zuerst gestartet werden)
	public static void main(String[] args) {
		final int ACK = 0x06;
	  	final int ETX = 0x03;
	    String text = "Hallo Welt!";
		Serial comm ;
		Scanner sc = new Scanner(System.in);
		String serialPort = "COM3";

		try {
			comm = new Serial(serialPort, 9600,
								Serial.DATABITS_8,
								Serial.STOPBITS_1,
								Serial.PARITY_NONE);

			if (comm.open()) {
			    System.out.println("Sender gestartet!");
			    while (! comm.isDSR());
			    System.out.println("Empfaenger betriebsbereit");
			    System.out.println("Warte auf ACK");
			    while (comm.read() != ACK);
			    System.out.println("ACK erhalten");
			    System.out.println("Schreibe: " + text);
			    comm.write(text);
			    comm.write(ETX);
			    System.out.println("Warte auf ACK");
			    while (comm.read() != ACK);
			    System.out.println("ACK erhalten");
			    System.out.println("Uebertragung beendet.");
			    while (comm.isDSR());
			    System.out.println("Empfaenger nicht mehr betriebsbereit");
			    sc.nextLine();
			  }
			  else {
			    System.out.println("Fehler beim Oeffnen von " + serialPort);
			  }
			System.out.println("Enter-Taste druecken.");
			System.out.print("Press Return .... ");
			sc.nextLine();
		} catch (Exception e) {
			System.err.println("Fehler: " + e.getMessage());
		}
	}

}
