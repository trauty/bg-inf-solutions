import java.awt.event.HierarchyBoundsAdapter;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Spiel 
{
	private final int xSize = 5;
	private final int ySize = 5;

	private boolean spielFeld[][] = new boolean[xSize][ySize];
	
	public Spiel()
	{
		startGame();
	}
	
	private void startGame()
	{
		Scanner in = new Scanner(System.in);
		
		while(true)
		{
			int ranX = ThreadLocalRandom.current().nextInt(0, xSize);
			int ranY = ThreadLocalRandom.current().nextInt(0, ySize);
			
			System.out.println("Das ist das Feld: \n");
			
			for (int x = 0; x < xSize; x++)
			{
				for (int y = 0; y < ySize; y++)
				{
					System.out.print("O   ");
				}
				
				System.out.println("\n");
			}
			
			System.out.println("Wo könnte die Maus sein?");
			System.out.print("X-Koordinate:");
			int xCoord = in.nextInt();
			System.out.print("Y-Koordinate:");
			int yCoord = in.nextInt();
			
			spielFeld[ranX][ranY] = true;
			
			if (ranX + 1 == xCoord && ranY + 1 == yCoord)
			{
				System.out.println("Du hast die Maus erwischt, Glückwunsch!");
			}
			else 
			{
				System.out.println("Du hast verfehlt! Viel Glück beim nächsten Mal!");
			}
			
			System.out.println("Hier ist die Maus:\n");
			
			for (int x = 0; x < xSize; x++)
			{
				for (int y = 0; y < ySize; y++)
				{
					System.out.print((spielFeld[x][y] ? "M" : "O") + "   ");
				}
				
				System.out.println("\n");
			}
			
			System.out.println("Nochmal? Dann schreib 'ja'.");
			String buf = in.next();
			if (!buf.equals("ja"))
			{
				break;
			}
		}
	}
}
