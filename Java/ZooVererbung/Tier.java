public class Tier
{
    private double gewicht;

    private String name;

    private boolean lebendig;

    private Zoo zoo;

    public Tier(String name, double gewicht, boolean lebendig, Zoo zoo)
    {
        this.name = name;
        this.gewicht = gewicht;
        this.lebendig = lebendig;
        this.zoo = zoo;

        zoo.nimmTierAuf(this);
    }

    public String getName() { return name; }

    public double getGewicht() { return gewicht; }

    public boolean istLebendig() { return lebendig; }

    public Zoo getZoo() { return zoo; }

    public void setLebendig(boolean neuerWert) { lebendig = neuerWert; }
}
