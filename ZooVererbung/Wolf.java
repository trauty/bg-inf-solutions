public class Wolf extends Fleischfresser 
{
    public Wolf(String name, double gewicht, boolean lebendig, Zoo zoo)
    {
        super(name, gewicht, lebendig, true, zoo);
    }

    public void erlege(Tier beutetier)
    {
        beutetier.setLebendig(false);
        super.friss(beutetier);
    }
}
