public class TransferAccount extends Account
{
    public TransferAccount(float kontostand)
    {
        super(kontostand);
    }

    @Override
    public float geldAbbuchen(float betrag)
    {
        if (getKontostand() - betrag >= -2000.0f)
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
