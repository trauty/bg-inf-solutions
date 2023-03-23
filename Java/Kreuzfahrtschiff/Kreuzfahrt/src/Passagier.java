public class Passagier
{
    private String vorname = "";
    private String nachname = "";

    public Passagier(String vn, String nn)
    {
        this.vorname = vn;
        this.nachname = nn;
    }

    public String toString()
    {
        return vorname + " " + nachname;
    }

    public String getVorname()
    {
        return vorname;
    }

    public String getNachname()
    {
        return nachname;
    }
}
