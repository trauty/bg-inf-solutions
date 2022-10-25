import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Account
{
    private String kontonummer = "";
    private float kontostand = 0.0f;

    ArrayList<Float> transaktionen = new ArrayList<>();

    public Account(float kontostand)
    {
        this.kontostand = kontostand;

        for (int i = 0; i < 9; i++)
        {
            kontonummer += ThreadLocalRandom.current().nextInt(10);
        }
    }

    public void geldEinzahlen(float betrag)
    {
        kontostand += betrag;
        transaktionen.add(betrag);
    }
    public float geldAbbuchen(float betrag)
    {
        kontostand -= betrag;
        transaktionen.add(-betrag);
        return betrag;
    }
    public void undoLastOperation()
    {
        if (transaktionen.size() != 0)
        {
            kontostand -= transaktionen.get(transaktionen.size() - 1);
            transaktionen.remove(transaktionen.size() - 1);
        }
        else
        {
            System.out.println("Konnte Transaktion nicht rueckgangig machen, da keine bisher ausgeführt wurden!");
        }
    }

    public String toString()
    {
        return "Kontonummer: " + kontonummer + "\n" +
                "Kontostand: " + kontostand + "\n";
    }


    public String getKontonummer() { return kontonummer; }
    public float getKontostand() { return kontostand; }
}
