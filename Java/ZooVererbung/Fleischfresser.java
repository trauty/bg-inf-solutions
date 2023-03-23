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
            if (beutetier.getZoo() == this.getZoo())
            {
                if (!beutetier.istLebendig())
                {
                    if (this.istLebendig())
                    {
                        System.out.println("Fresse " + beutetier.getName());
                        ausgabe(beutetier);
                    }
                    else
                    {
                        System.out.println(this.getName() + " kann keine Tiere fressen, da er tot ist!");
                    }
                }
                else
                {
                    System.out.println(this.getName() + " kann nicht Tiere fressen, wenn sie noch lebendig sind!");
                }
            }
            else
            {
                System.out.println(this.getName() + " kann nicht " + beutetier.getName() + " aus einem anderen Zoo fressen!");
            }
        }
        else
        {
            System.out.println(this.getName() + " kann leider nicht sich selber fressen!");
        }
    }

    private void ausgabe(Tier beutetier)
    {
        mageninhalt.add(beutetier);
        this.getZoo().loescheTier(beutetier);

        String ausgabeString = "";

        if (beutetier.getClass().getName().equals("Wolf") || beutetier.getClass().getName().equals("Hyaene"))
        {
            ausgabeString += beutetier.getName() + ": Igitt Igitt";
        }
        else if (beutetier.getClass().getName().equals("Hase"))
        {
            Pflanzenfresser pflanzenfresser = (Pflanzenfresser) beutetier;
            ausgabeString += beutetier.getName() + "s Lieblingspflanze: " + pflanzenfresser.getLieblingspflanze() + "\n";
        }
        else if (beutetier.getClass().getName().equals("Reh"))
        {
            Reh reh = (Reh) beutetier;
            ausgabeString += beutetier.getName() + "s Lieblingspflanze: " + reh.getLieblingspflanze() + "\n";
            if (reh.hasGeweih())
            {
                ausgabeString += beutetier.getName() + ": Vorsicht! Spitzes Geweih!";
            }
            else
            {
                ausgabeString += beutetier.getName() + ": Hmm...schoen saftig!";
            }
        }

        System.out.println(ausgabeString);
    }

    public String magenInhalt()
    {
        String buffer = "";
        for (Tier tier : mageninhalt)
        {
            buffer += tier.getName() + ", ";
        }
        return buffer;
    }

    public boolean istJeager() { return istJaeger; }
}
