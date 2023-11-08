public class Warteschlange
{
    private int anzahlBestellungen;
    private int maxBestellungen;
    private boolean geoeffnet;

    private Bestellung anfang;
    private Bestellung ende;

    public Warteschlange (int maxBestellungen)
    {
        this.maxBestellungen = maxBestellungen;
        geoeffnet = true;
    }

    public boolean einfuegen(Bestellung neu)
    {
        if (!geoeffnet) { return false; }

        if (anzahlBestellungen == maxBestellungen)
        {
            return false;
        }

        if (anfang == null)
        {
            anfang = neu;
        }
        else
        {
            Bestellung letzter = ende;
            ende = neu;
            letzter.setNaechste(neu);
        }

        anzahlBestellungen++;
        return true;
    }

    public Bestellung entnehmen()
    {
        if (!geoeffnet) { return null; }
        Bestellung temp = anfang;
        if (anfang.getNaechste() != null)
        {
            anfang = temp.getNaechste();
        }
        else
        {
            anfang = null;
            ende = null;
        }
        return temp;
    }

    public void schliessen()
    {
        geoeffnet = false;
    }
}
