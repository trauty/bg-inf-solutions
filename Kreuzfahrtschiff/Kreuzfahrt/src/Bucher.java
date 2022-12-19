public class Bucher extends Passagier
{
    private String email = "";
    private String iban = "";

    public Bucher(String vn, String nn, String email, String iban)
    {
        super(vn, nn);
        this.email = email;
        this.iban = iban;
    }

    public String toString()
    {
        return getVorname() + " " + getNachname()
                + ", Email: " + email + ", IBAN: " + iban;
    }
}
