public class Pflanzenfresser extends Tier
{
    private String lieblingsPflanze;

    public Pflanzenfresser(String name, double gewicht, boolean lebendig, String lieblingsPflanze, Zoo zoo)
    {
        super(name, gewicht, lebendig, zoo);
        this.lieblingsPflanze = lieblingsPflanze;
    }

    public String getLieblingspflanze() { return lieblingsPflanze; }
}
