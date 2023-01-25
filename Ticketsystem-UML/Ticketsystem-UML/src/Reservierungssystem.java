import java.util.ArrayList;

public class Reservierungssystem
{
    private ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    private ArrayList<Spiel> spiele = new ArrayList<Spiel>();
    private ArrayList<Reservierung> reservierungen = new ArrayList<Reservierung>();

    public Reservierung reservierePlaetze(Kunde kunde, Spiel spiel, String blockbez, int reihe, int vonPlatz, int bisPlatz)
    {
        Block block = spiel.sucheBlock(blockbez);

        for (int x = 0; x < block.getReihen(); x++)
        {
            for (int y = 0; y < block.getPlatze(); y++)
            {
                if (!block.istFrei(x, y)) { return null; }
            }
        }

        for (int i = 0; i <= vonPlatz - bisPlatz; i++)
        {
            block.belegePlatz(reihe, vonPlatz + i);
        }

        return new Reservierung(kunde, spiel, block, reihe, vonPlatz, bisPlatz);
    }

    public boolean storniereReservierung(int reservNummer)
    {
        Reservierung foundRes = null;

        int iter = 0;

        for (Reservierung res : reservierungen)
        {
            iter++;
            if (res.getNummer() == reservNummer)
            {
                foundRes = res;
                break;
            }
        }

        if (foundRes == null)
        {
            return false;
        }

        for (int i = 0; i <= foundRes.getVonPlatz() - foundRes.getBisPlatz(); i++)
        {
            foundRes.getBlock().belegePlatz(foundRes.getReihe(), foundRes.getVonPlatz());
        }

        reservierungen.remove(foundRes);

        for (Kunde kunde : kunden)
        {
            try
            {
                if (kunde.getReservierungen().get(iter) == foundRes)
                {
                    kunde.loescheReservierung(kunde.getReservierungen().get(iter));
                }
            }
            catch (Exception exc)
            {
                exc.printStackTrace();
            }
        }

        for (Spiel s : spiele)
        {
            try
            {
                if (s.getReservierungen().get(iter) == foundRes)
                {
                    s.loescheReservierung(s.getReservierungen().get(iter));
                }
            }
            catch (Exception exc)
            {
                exc.printStackTrace();
            }
        }

        return true;
    }
}
