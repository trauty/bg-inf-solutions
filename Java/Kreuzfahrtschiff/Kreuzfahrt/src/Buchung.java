import java.util.ArrayList;
import java.util.Date;

public class Buchung
{
    private int buchungsNr = 0;
    private Date buchungsDatum = null;
    private int kategorie = 0;
    private static int autowert = 1;

    private ArrayList<Passagier> passagiere = new ArrayList<>();

    private Kreuzfahrt fahrt = null;

    private Bucher bucher;

    public Buchung(Bucher b, Kreuzfahrt k, int kat)
    {
        this.bucher = b;
        this.fahrt = k;
        this.kategorie = kat;
    }

    public ArrayList<Passagier> getPassagiere()
    {
        return passagiere;
    }

    public void hinzufuegenPassagier(Passagier passagier)
    {
        passagiere.add(passagier);
    }

    public int getKategorie()
    {
        return kategorie;
    }
}
