import java.util.ArrayList;

public class Spiel
{
    private int spielNr;
    private DateTime zeit;
    private String team1;
    private String team2;
    private String stadionName;

    private ArrayList<Reservierung> reservierungen = new ArrayList<>();
    private Block[] bloecke = new Block[4];

    public Spiel(int spielNr, DateTime zeit, String stadion)
    {
        this.spielNr = spielNr;
        this.zeit = zeit;
        stadionName = stadion;

        bloecke[0] = new Block("Nord");
        bloecke[1] = new Block("Ost");
        bloecke[2] = new Block("Süd");
        bloecke[3] = new Block("West");
    }

    public void loescheReservierung(Reservierung r)
    {
        reservierungen.remove(r);
    }

    public Block sucheBlock(String bezeichnung)
    {
        for (Block b : bloecke)
        {
            if (b.getBezeichnung().equals(bezeichnung))
            {
                return b;
            }
        }

        return null;
    }

    public void hinzufuegenReservierung(Reservierung r)
    {
        reservierungen.add(r);
    }

    public ArrayList<Reservierung> getReservierungen() { return reservierungen; }
}
