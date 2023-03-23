public class Schuetze 
{
	private int[] treffer;
	
	public void trefferEinfuegen(int pTreffer)
	{
		treffer[pTreffer - 1]++; 
	}
	
	public int zusammenzaehlen()
	{
		int buf = 0;
		
		for (int i = 0; i < treffer.length; i++)
		{
			buf += treffer[i];
		}
		
		return buf;
	}
	
	public int[] getTreffer() 
	{
		return treffer;
	}
	
}
