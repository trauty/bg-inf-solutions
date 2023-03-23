import java.util.ArrayList;

public class Reservierungssystem
{
    private ArrayList<Kunde> kunden = new ArrayList<Kunde>();
    private ArrayList<Spiel> spiele = new ArrayList<Spiel>();
    private ArrayList<Reservierung> reservierungen = new ArrayList<Reservierung>();

    public Reservierung reservierePlaetze(Kunde kunde, Spiel spiel, String blockbez, int reihe, int vonPlatz, int bisPlatz)
    {
        Block block = spiel.sucheBlock(blockbez);

        for (int x = 0; x < bisPlatz - vonPlatz; x++)
        {
            if (!block.istFrei(reihe, vonPlatz + x - 1)) { return null; }
        }

        for (int i = 0; i <= bisPlatz - vonPlatz; i++)
        {
            block.belegePlatz(reihe, vonPlatz + i - 1);
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

        for (int i = 0; i <= foundRes.getBisPlatz() - foundRes.getVonPlatz(); i++)
        {
            foundRes.getBlock().belegePlatz(foundRes.getReihe(), foundRes.getVonPlatz() + i - 1);
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
