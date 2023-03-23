import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Kreuzfahrt
{
    private String zielgebiet = "";
    private Date startDatum = null;
    private int anzahlTage = 0;
    private Schiff kreuzfahrtschiff = null;

    private ArrayList<Buchung> buchungen = new ArrayList<>();

    public Kreuzfahrt(String ziel, Schiff schiff, Date start, int tage)
    {
        this.zielgebiet = ziel;
        this.kreuzfahrtschiff = schiff;
        this.startDatum = start;
        this.anzahlTage = tage;
    }

    public void hinzufuegenBuchung(Buchung b)
    {
        buchungen.add(b);
    }

    public Schiff getKreuzfahrtschiff()
    {
        return kreuzfahrtschiff;
    }

    public ArrayList<Buchung> getBuchungen()
    {
        return buchungen;
    }
}
