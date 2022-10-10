public class Zoo 
{   
    private String name;
    private Tierliste tierliste;

    public Zoo(String name)
    {
        this.name = name;
        tierliste = new Tierliste();
    }

    public boolean nimmTierAuf(Tier zootier)
    {
        return tierliste.fuegeHinzu(zootier);
    }

    public boolean loescheTier(Tier opfer)
    {
        return tierliste.loesche(opfer);
    }

    public String toString()
    {
        return name + ": " + tierliste.getNames();
    }
}
