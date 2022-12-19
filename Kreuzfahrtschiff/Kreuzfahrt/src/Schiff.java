import java.io.Serial;
import java.util.List;

public class Schiff
{
    private String name = "";
    private int anzahlKabinen = 0;

    private int counter = 0;

    private Kabine[] kabinen;

    public Schiff(String name, int anzKab)
    {
        this.name = name;
        this.anzahlKabinen = anzKab;
        kabinen = new Kabine[anzahlKabinen];

        for (int i = 0; i < 3; i++)
        {
            kabinen[i] = new Kabine(i, 0, 3);
        }

        for (int i = 2; i < 5; i++)
        {
            kabinen[i] = new Kabine(i, 0, 2);
        }
    }

    public Kabine sucheFreieKabine(int kategorie)
    {
        Kabine kabGef = null;

        for (int i = 0; i < anzahlKabinen; i++)
        {
            if (kabinen[i].getKategorie() == kategorie && kabinen[i].getBewohner()[0] == null)
            {
                kabGef = kabinen[i];
                return kabGef;
            }
        }

        return kabGef;
    }

    public int getAnzahlKabinen()
    {
        return anzahlKabinen;
    }

    public Kabine[] getKabinen()
    {
        return kabinen;
    }
}
