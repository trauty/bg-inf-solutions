public class Bestellposition
{
    private int posNr;
    private int menge;
    private Pizza pizza;

    public Bestellposition(int posNr, Pizza p, int menge)
    {
        this.posNr = posNr;
        this.menge = menge;
        this.pizza = p;
    }

    public Pizza getPizza()
    {
        return pizza;
    }
}
