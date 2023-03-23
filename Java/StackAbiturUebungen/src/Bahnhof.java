import java.nio.Buffer;

public class Bahnhof 
{
	private Gleis[] gleise = new Gleis[3];
	
	public void rangieren(Gleis von, Gleis nach)
	{
		nach.abstellen(von.entnehmen());
	}
	
	public void umordnen() // das ist das Schlechteste, was ich je programmiert habe
	{
		while (!gleise[1].istFrei())
		{
			Waggon bufWaggon = gleise[1].entnehmen();
			
			if (bufWaggon.getZiel() == "A")
			{
				gleise[0].abstellen(bufWaggon);
			}
			else 
			{
				gleise[2].abstellen(bufWaggon);
			}
		}
		
		while (!gleise[2].istFrei())
		{
			Waggon bufWaggon = gleise[2].entnehmen();
			
			if (bufWaggon.getZiel() == "A")
			{
				gleise[0].abstellen(bufWaggon);
			}
			else 
			{
				gleise[1].abstellen(bufWaggon);
			}
		}
	}
}