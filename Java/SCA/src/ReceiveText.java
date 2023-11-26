

import serialio.Serial;
import java.util.*;

public class ReceiveText {

	public static void main(String[] args) {
		final int ACK = 0x06;
	  	final int ETX = 0x03;
		int ch;
		Serial comm;
		Scanner sc = new Scanner(System.in);
		String serialPort = "COM3";


	try {
			comm = new Serial(serialPort, 9600,
							  Serial.DATABITS_8,
							  Serial.STOPBITS_1,
							  Serial.PARITY_NONE);
			if (comm.open()) {
			    System.out.println("Betriebsbereitschaft signalisieren");
			    comm.setDTR(true);
			    System.out.println("Empfaenger gestartet");
			    System.out.println("Sende ACK");
			    comm.write(ACK);
			    System.out.println("Empfange Text:");
			    while ((ch = comm.read()) != ETX)
			    	System.out.print((char)ch);
			    System.out.println("\nSende ACK");
			    comm.write(ACK);
			    System.out.println("Uebertragung beendet.");
			    comm.setDTR(false);
			    System.out.println("Betriebsbereitschaft beendet");
			    comm.close();
			}
			else {
				System.out.println("Fehler beim Oeffnen von " + serialPort);
			}
			System.out.println("Enter-Taste druecken.");
			sc.nextLine();
		} catch (Exception e) {
			System.err.println("Fehler: " + e.getMessage());
		}
	}
}
