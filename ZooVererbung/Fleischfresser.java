import java.util.ArrayList;

public class Fleischfresser extends Tier
{
    private boolean istJaeger;
    private ArrayList<Tier> mageninhalt = new ArrayList<>();

    public Fleischfresser(String name, double gewicht, boolean lebendig, boolean istJaeger, Zoo zoo)
    {
        super(name, gewicht, lebendig, zoo);
        this.istJaeger = istJaeger;
    }

    public void friss(Tier beutetier)
    {
        if (beutetier != this)
        {
            ausgabe(beutetier);
            return;
        }
        else
        {
            System.out.println(this.getName() + "kann leider nicht sich selber fressen!");
        }
        if (beutetier.getZoo() == this.getZoo())
        {
            ausgabe(beutetier);
            return;
        }
        else
        {
            System.out.println(this.getName() + "kann nicht Tiere aus einem anderen Zoo fressen!");
        }
        if (beutetier.istLebendig())
        {
            ausgabe(beutetier);
            return;
        }
        else
        {
            System.out.println(this.getName() + "kann nicht Tiere fressen, wenn sie nicht .istLebendig() sind!");
        }
        if (this.istLebendig())
        {
            ausgabe(beutetier);
            return;
        }
        else
        {
            System.out.println(this.getName() + "kann keine Tiere fressen, da er tot ist!");
        }
    }

    private void ausgabe(Tier beutetier)
    {
        mageninhalt.add(beutetier);
        this.getZoo().loescheTier(beutetier);

        String ausgabeString = "";

        if (beutetier.getClass().getName().equals("Fleischfresser"))
        {
            ausgabeString = beutetier.getName() + ": Igitt Igitt";
        }
        else if (beutetier.getClass().getName().equals("Pflanzenfresser"))
        {
            Pflanzenfresser pflanzenfresser = (Pflanzenfresser)beutetier;
            ausgabeString = beutetier.getName() + "'s Lieblingspflanze: " + pflanzenfresser.getLieblingspflanze();
        }
        else if (beutetier.getClass().getName().equals("Reh"))
        {
            Reh reh = (Reh)beutetier;
            if (reh.hasGeweih())
            {
                ausgabeString = beutetier.getName() + ": Vorsicht! Spitzes Geweih!";
            }
            else
            {
                ausgabeString = beutetier.getName() + ": Hmm...schoen saftig!";
            }
        }

        System.out.println(ausgabeString);
    }

    public String magenInhalt()
    {
        String buffer = "Mageninhalt von " + this.getName() + ": ";
        for (Tier tier : mageninhalt)
        {
            buffer += tier.getName() + ", ";
        }

        return buffer;
    }

    public boolean istJeager() { return istJaeger; }
}
