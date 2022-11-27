import java.util.concurrent.ThreadLocalRandom;

public class Ticket
{
    public static final int UNGELOEST = 1;
    public static final int INBEARBEITUNG = 2;
    public static final int GELOEST = 3;
    public static final int GESCHLOSSEN = 4;

    private static int autoWert = 1;

    private int ticketId;
    private DateTime erfassungsdatum;
    private String betreff;
    private String beschreibung;
    private String loesung;
    private int status;

    private Mitarbeiter erfasser;
    private Mitarbeiter bearbeiter;
    private Kunde kunde;

    public Ticket(Kunde kunde, Mitarbeiter erfasser, String betreff, String beschreibung)
    {
        this.kunde = kunde;
        this.erfasser = erfasser;
        this.betreff = betreff;
        this.beschreibung = beschreibung;
        status = UNGELOEST;

        ticketId = ThreadLocalRandom.current().nextInt(99999999);
    }

    public void zuordnenBearbeiter(Mitarbeiter bearbeiter)
    {
        this.bearbeiter = bearbeiter;
        status = INBEARBEITUNG;
    }

    public void eintragenLoesung(String loesung)
    {
        this.loesung = loesung;
        status = GELOEST;
    }

    public void schliessen()
    {
        status = GESCHLOSSEN;
    }
}
