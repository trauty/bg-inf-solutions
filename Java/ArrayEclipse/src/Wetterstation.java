// Diese Implementationen gehen von vollständigen Daten aus

public class Wetterstation 
{
	private float daten[][] = new float[7][24];
	
	public Wetterstation(float daten[][])
	{
		this.daten = daten;
	}
	
	public float berechneDurchschnittTag(int tag)
	{
		float buf = 0.0f;
		
		for (int i = 0; i < 24; i++)
		{
			buf += daten[tag][i];
		}
		
		return buf / 24;
	}
	
	public float berechneDurchschnittWoche()
	{
		float buf = 0.0f;
		
		for (int i = 0; i < 7; i++)
		{
			buf += berechneDurchschnittTag(i);
		}
		
		return buf / 7;
	}
	
	// Diese Methode könnte bei gleichen Werten die Stunde überschreiben
	public int kuehlsteStunde()
	{
		float buf = Float.MAX_VALUE;
		int stunde = 0;
		
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 24; j++)
			{
				if (daten[i][j] < buf)
				{
					buf = daten[i][j];
					stunde = i * j;
				}
			}
		}
		
		return stunde;
	}
	
	// Diese Methode könnte bei gleichen Werten die Stunde überschreiben
	public int waermsteStunde()
	{
		float buf = 0.0f;
		int stunde = 0;
		
		for (int i = 0; i < 7; i++)
		{
			for (int j = 0; j < 24; j++)
			{
				if (daten[i][j] > buf)
				{
					buf = daten[i][j];
					stunde = i * j;
				}
			}
		}
		
		return stunde;
	}
	
	public float berDurchStunden()
	{
		float buf = 0.0f;
		
		for (int i = 0; i < 7; i++)
		{
			buf += daten[i][7];
			buf += daten[i][11];
			buf += daten[i][17];
		}
		
		return buf;
	}
}
