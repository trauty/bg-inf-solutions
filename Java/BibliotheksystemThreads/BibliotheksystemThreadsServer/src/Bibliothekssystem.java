import java.util.ArrayList;
import java.util.List;

public class Bibliothekssystem
{
    private List<Buch> buecher = new ArrayList<>();
    private List<Leser> leser = new ArrayList<>();

    public Bibliothekssystem()
    {

    }

    public Leser sucheLeser(int lesernr)
    {
        for (Leser crtLeser : leser)
        {
            if (crtLeser.getLesernr() == lesernr)
            {
                return crtLeser;
            }
        }

        return null;
    }

    public int ausleihen(Leser leser, Exemplar exemplar)
    {
        int status = exemplar.ausleihen(leser);
        if (status == 0)
        {
            leser.addAusleihe(exemplar);
        }

        return status;
    }

    public int zurueckgeben(Leser leser, Exemplar exemplar)
    {
        int status = exemplar.zurueckgeben();
        if (status == 0)
        {
            leser.removeAusleihe(exemplar);
        }

        return status;
    }

    public Exemplar sucheExemplar(String signatur)
    {
        for (Buch buch: buecher)
        {
            for (Exemplar exemplar : buch.getExemplare())
            {
                if (exemplar.getSignatur().equals(signatur))
                {
                    return exemplar;
                }
            }
        }

        return null;
    }

    public List<Buch> getBuecher()
    {
        return buecher;
    }

    public List<Leser> getLeser()
    {
        return leser;
    }
}
