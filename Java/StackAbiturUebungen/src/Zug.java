public class Zug 
{
	private int nummer;
	private int laenge;
	
	private Waggon erster;
	
	public Zug(int nummer)
	{
		this.nummer = nummer;
	}
	
	public void anhaengen(Waggon waggon)
	{
		laenge++;
		erster.setLastWaggon(waggon);
	}
	
	public Waggon abkoppeln()
	{
		laenge--;
		return erster.getLastWaggon();
	}
}
