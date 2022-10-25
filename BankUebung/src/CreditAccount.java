public class CreditAccount extends Account
{
    private boolean blockade = false;

    public CreditAccount(float kontostand)
    {
        super(kontostand);
        if (kontostand >= 0)
        {
            System.out.println("Kreditkarten dürfen nur mit negativen Beträgen initialisiert werden!");
            blockade = true;
        }
    }

    public void geldEinzahlen(float betrag)
    {
        if(!blockade && getKontostand() + betrag < 0)
        {
            super.geldEinzahlen(betrag);
        }
        else
        {
            System.out.println("Konnte nicht auf Kreditkonto einzahlen!");
        }
    }
}
