public class SavingsAccount extends Account
{
    public SavingsAccount(float kontostand)
    {
        super(kontostand);
    }

    @Override
    public float geldAbbuchen(float betrag)
    {
        if (getKontostand() - betrag > 0.0f)
        {
            return super.geldAbbuchen(betrag);
        }
        else
        {
            return 0.0f;
        }
    }

    public void geldEinzahlen(float betrag)
    {
        super.geldEinzahlen(betrag);
    }
}
