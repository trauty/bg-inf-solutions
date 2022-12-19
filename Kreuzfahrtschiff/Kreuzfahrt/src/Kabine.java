public class Kabine
{
    private int kabinenNr = 0;
    private int kategorie = 0;

    private Passagier[] bewohner = new Passagier[2];

    public Kabine(int nr, int deck, int kat)
    {
        this.kabinenNr = nr;
        this.kategorie = kat;
    }

    public void belegeKabine(Passagier[] passagiere)
    {
        this.bewohner = passagiere;
    }

    public int getKategorie()
    {
        return kategorie;
    }

    public Passagier[] getBewohner()
    {
        return bewohner;
    }
}
