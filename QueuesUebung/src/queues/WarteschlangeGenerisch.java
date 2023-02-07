package queues;

public class WarteschlangeGenerisch<T extends IWartGenFuncs>
{
	private int count;
	
	private T erster;
	
	public void enqueue(T s)
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
	
	public T dequeue() 
	{
		T curPerson = erster;
		erster = (T)erster.getNaechster();
		return curPerson;
	}
	
	public int size()
	{
		return count;
	}
	
	public void loeschen(T p)
	{
		erster.delItem(p);
	}
	
	public void display()
	{
		System.out.println(erster.toString());
	}
}
