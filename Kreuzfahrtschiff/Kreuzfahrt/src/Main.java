import java.util.Date;

public class Main
{
    public static void main(String[] args)
    {
        Bucher bucher = new Bucher("Hans", "Glück", "hans.im.Glueck@web.de", "DE2710077777020");
        Kreuzfahrt kreuzfahrt = new Kreuzfahrt("Indien", new Schiff("Dicke Berta", 20), new Date(), 20);
        Buchung buchung1 = new Buchung(bucher, kreuzfahrt, 3);
        Buchung buchung2 = new Buchung(bucher, kreuzfahrt, 2);

        buchung1.hinzufuegenPassagier(new Passagier("Martin", "Lime"));
        buchung1.hinzufuegenPassagier(new Passagier("Benjamin", "Franklin"));
        buchung1.hinzufuegenPassagier(new Passagier("Christoph", "Columbus"));

        kreuzfahrt.hinzufuegenBuchung(buchung1);

        buchung2.hinzufuegenPassagier(new Passagier("San", "Andreas"));
        buchung2.hinzufuegenPassagier(new Passagier("Daniel", "Dasy"));
        buchung2.hinzufuegenPassagier(new Passagier("Dorian", "Ronald"));

        kreuzfahrt.hinzufuegenBuchung(buchung2);

        KreuzfahrtenVerwaltung verw = new KreuzfahrtenVerwaltung();
        verw.belegeKabinen(kreuzfahrt);

        System.out.println(kreuzfahrt.getKreuzfahrtschiff().getKabinen().length);
    }
}