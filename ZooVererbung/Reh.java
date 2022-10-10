public class Reh extends Pflanzenfresser
{
    private boolean geweih;

    public Reh(String name, double gewicht, boolean lebendig, String lieblingsPflanze, boolean geweih, Zoo zoo)
    {
        super(name, gewicht, lebendig, lieblingsPflanze, zoo);
        this.geweih = geweih;
    }

    public boolean hasGeweih() { return geweih; }
}
