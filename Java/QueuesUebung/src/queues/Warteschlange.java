package queues;

public class Warteschlange 
{
	private int count;
	
	private Person erster;
	
	public void enqueue(Person s)
	{
		count++;
		if (erster == null)
		{
			erster = s;
		}
		else 
		{
			erster.setNaechster(s);	
		}
	}
	
	public Person dequeue() 
	{
		Person curPerson = erster;
		erster = erster.getNaechster();
		return curPerson;
	}
	
	public int size()
	{
		return count;
	}
	
	public void loeschen(Person p)
	{
		erster.delItem(p);
	}
	
	public void display()
	{
		System.out.println(erster.toString());
	}
}
