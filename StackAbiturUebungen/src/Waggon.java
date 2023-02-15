import java.io.ObjectInputStream.GetField;

public class Waggon 
{
	private String ziel;
	
	private Waggon naechster = null;
	
	public Waggon(String ziel)
	{
		this.ziel = ziel;
	}
	
	public void setLastWaggon(Waggon waggon)
	{
		if (naechster == null)
		{
			this.naechster = waggon;
		}
		else 
		{
			naechster.setLastWaggon(waggon);
		}
	}
	
	public Waggon getLastWaggon()
	{
		if (naechster.getNaechster() == null)
		{
			Waggon buf = naechster;
			naechster = null;
			return buf;
		}
		else
		{
			return naechster.getLastWaggon();
		}
	}
	
	public Waggon getNaechster()
	{
		return naechster;
	}
	
	public String getZiel()
	{
		return ziel;
	}
}
