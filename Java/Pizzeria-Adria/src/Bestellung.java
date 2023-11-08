import java.util.ArrayList;
import java.util.Date;

public class Bestellung
{
    private int bestellNr;
    private Date datum;
    private static int nrGlobal;
    private int posNr = 1;

    private Bestellung naechste;
    private ArrayList<Bestellposition> positionen = new ArrayList<>();

    public Bestellung()
    {
        nrGlobal++;
        bestellNr = nrGlobal;
    }

    public void hinzufuegenBestellposition(Pizza p, int menge)
    {
        positionen.add(new Bestellposition(posNr, p, menge));
        posNr++;
    }

    public double berechneSumme()
    {
        double summe = 0.0;

        for (Bestellposition pos : positionen)
        {
            summe += pos.getPizza().getPreis();
        }

        return summe;
    }

    public Bestellung getNaechste()
    {
        return naechste;
    }
    public void setNaechste(Bestellung naechste)
    {
        this.naechste = naechste;
    }
    public static int getNrGlobal()
    {
        return nrGlobal;
    }
}
