import java.util.ArrayList;
import java.util.List;

public class Leser
{
    private static int maxAusleihen;
    private List<Exemplar> ausleihen;
    private int lesernr;
    private String name;

    public Leser(int lesernr, String name)
    {
        this.lesernr = lesernr;
        this.name = name;
        ausleihen = new ArrayList<>(maxAusleihen);
    }

    public boolean hatAusleihen()
    {
        return ausleihen.size() != 0;
    }

    public void addAusleihe(Exemplar exemplar)
    {
        ausleihen.add(exemplar);
    }

    public boolean removeAusleihe(Exemplar exemplar)
    {
        return ausleihen.remove(exemplar);
    }

    public int getMaxAusleihen()
    {
        return maxAusleihen;
    }

    public List<Exemplar> getAusleihen()
    {
        return ausleihen;
    }

    public int getLesernr()
    {
        return lesernr;
    }

    public String getName()
    {
        return name;
    }
}
