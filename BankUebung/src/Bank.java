import java.util.ArrayList;

public class Bank
{
    private String name = "";
    private int bankleitzahl = 0;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Bank(String name, int bankleitzahl)
    {
        this.name = name;
        this.bankleitzahl = bankleitzahl;
    }

    private String sortAccounts()
    {
        int accountsLaenge = accounts.size();
        Account tempVal;

        for (int i = 0; i < accountsLaenge; i++)
        {
            for (int j = 1; j < accountsLaenge - i; j++)
            {
                if (accounts.get(j - 1).getKontostand() > accounts.get(j).getKontostand())
                {
                    tempVal = accounts.get(j - 1);
                    accounts.set(j - 1, accounts.get(j));
                    accounts.set(j, tempVal);
                }
            }
        }

        String ausgabe = "Konten sortiert nach Kontostand: \n";
        for(Account crtAcc : accounts)
        {
            ausgabe += crtAcc.getKontonummer() + " : " + crtAcc.getKontostand() + " Euro\n";
        }

        return ausgabe;
    }

    public String toString()
    {
        return "Bank: " + name + "\n" +
                "Bankleitzahl: " + bankleitzahl + "\n" +
                sortAccounts();
    }

    public void kontoHinzufuegen(Account konto)
    {
        accounts.add(konto);
    }

    public String getName() { return name; }
    public int getBankleitzahl() { return bankleitzahl; }
}
