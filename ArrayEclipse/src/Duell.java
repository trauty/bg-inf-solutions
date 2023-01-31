import java.awt.font.TextHitInfo;

public class Duell 
{
	public Schuetze besterSchuetze(Schuetze schuetze1, Schuetze schuetze2)
	{
		int res1 = schuetze1.zusammenzaehlen();
		int res2 = schuetze2.zusammenzaehlen();
		
		if (res1 < res2)
		{
			return schuetze2;
		}
		else if (res1 > res2) 
		{
			return schuetze1;
		}
		else
		{
			return null;
		}
	}
}
