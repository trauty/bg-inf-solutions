public class Ticket
{
    public static final int UNGELOEST = 1;
    public static final int INBEARBEITUNG = 2;
    public static final int GELOEST = 3;
    public static final int GESCHLOSSEN = 4;

    private static int autoWert = 1;

    private int ticketId;
    private DateTime erfassungsdatum;
}
