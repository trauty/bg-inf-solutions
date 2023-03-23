package queues;

public class Person implements IWartGenFuncs<Person>
{
	private String name;
	private String vorname;
	
	private Person naechster;
	
	public Person(String name, String vorname)
	{
		this.name = name;
		this.vorname = vorname;
	}
	
	public String toString()
	{
		String buffer = "";
		
		if (naechster != null)
		{
			buffer += naechster.toString();
		}
		
		buffer += vorname + " " + name + "\n";
		
		return buffer;
	}
	
	public void setNaechster(Person p)
	{
		if (naechster == null)
		{
			this.naechster = p;
		}
		else 
		{
			naechster.setNaechster(p);
		}
	}
	
	public Person getNaechster() 
	{
		return naechster;
	}
	
	public void delItem(Person p)
	{
		if (p == naechster)
		{
			naechster = naechster.getNaechster();
		}
		else if(naechster != null)
		{
			this.naechster.delItem(p);
		}
	}
}
