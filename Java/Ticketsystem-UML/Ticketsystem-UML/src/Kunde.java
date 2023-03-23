import java.util.ArrayList;

public class Kunde
{
    private ArrayList<Reservierung> reservierungen = new ArrayList<>();

    public void loescheReservierung(Reservierung r) { reservierungen.remove(r); }

    public ArrayList<Reservierung> getReservierungen() { return reservierungen; }
}
