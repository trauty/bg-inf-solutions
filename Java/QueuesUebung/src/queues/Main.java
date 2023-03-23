package queues;

public class Main 
{
	public static void main(String[] args) 
	{
		testGenerisch();
	}
	
	public static void normalerTest()
	{
		Warteschlange ws = new Warteschlange();
		Person p = new Person("Borrs", "Tyler");
		ws.enqueue(p);		
		p = new Person("Boschmann", "Simon");
		ws.enqueue(p);
		p = new Person("Durilkin", "Andrej");
		ws.enqueue(p);
		Person p1 = new Person("Gärtner", "Paul");
		ws.enqueue(p1);
		p = new Person("Hahl", "Julius");
		ws.enqueue(p);
		p = new Person("Köhler", "Sebastian");
		ws.enqueue(p);

		System.out.println(ws.dequeue());
		System.out.println(ws.dequeue());
		
		ws.display();
		ws.loeschen(p1);
		ws.display();
	}
	
	public static void testGenerisch()
	{
		WarteschlangeGenerisch<Person> ws = new WarteschlangeGenerisch<Person>();
		Person p = new Person("Borrs", "Tyler");
		ws.enqueue(p);		
		p = new Person("Boschmann", "Simon");
		ws.enqueue(p);
		p = new Person("Durilkin", "Andrej");
		ws.enqueue(p);
		Person p1 = new Person("Gärtner", "Paul");
		ws.enqueue(p1);
		p = new Person("Hahl", "Julius");
		ws.enqueue(p);
		p = new Person("Köhler", "Sebastian");
		ws.enqueue(p);

		
		ws.display();

		System.out.println(ws.dequeue());
		System.out.println(ws.dequeue());
		
		ws.display();
		ws.loeschen(p1);
		ws.display();
	}
}
