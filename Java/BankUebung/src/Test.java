public class Test
{
    public static void main(String[] args)
    {
        Bank bank = new Bank("Trautwein'sche Bank", 90865046);
        SavingsAccount sparkonto = new SavingsAccount(500.0f);
        bank.kontoHinzufuegen(sparkonto);
        CreditAccount kreditkonto = new CreditAccount(-100.0f);
        bank.kontoHinzufuegen(kreditkonto);
        TransferAccount girokonto = new TransferAccount(1000.0f);
        bank.kontoHinzufuegen(girokonto);

        kreditkonto.geldEinzahlen(sparkonto.geldAbbuchen(250.0f));

        System.out.println(bank.toString());
    }
}
