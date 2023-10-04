import java.util.Date;

public class Exemplar
{
    private Date ausleihDatum;
    private String signatur;

    private Buch buch;
    private Leser ausleiher;

    public Exemplar(String signatur, Buch buch)
    {
        this.signatur = signatur;
        this.buch = buch;
    }

    public boolean istAusgeliehen()
    {
        return ausleiher != null;
    }

    public Date spaetestesRueckgabeDatum()
    {
        return new Date(ausleihDatum.getTime() + (long)buch.getAusleihDauer() * 86400000L);
    }

    public int ausleihen(Leser leser)
    {
        if (ausleiher.getAusleihen().size() >= ausleiher.getMaxAusleihen())
        {
            return 2;
        }
        else if (ausleiher != null)
        {
            return 1;
        }
        else
        {
            ausleiher = leser;
            return 0;
        }
    }

    public int zurueckgeben()
    {
        if (ausleiher == null)
        {
            return 2;
        }
        else if ((spaetestesRueckgabeDatum().compareTo(new Date(System.currentTimeMillis() / 1000L)) > 0))
        {
            return 1;
        }
        else
        {
            ausleiher = null;
            return 0;
        }
    }

    public Date getAusleihDatum()
    {
        return ausleihDatum;
    }

    public String getSignatur()
    {
        return signatur;
    }

    public Buch getBuch()
    {
        return buch;
    }

    public Leser getAusleiher()
    {
        return ausleiher;
    }
}
