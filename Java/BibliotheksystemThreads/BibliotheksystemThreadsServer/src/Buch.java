import java.util.ArrayList;
import java.util.List;

public class Buch
{
    private List<Exemplar> exemplare = new ArrayList<>();
    private static int ausleihDauer;
    private String isbn;
    private String titel;

    public Buch(String isbn, String titel)
    {
        this.isbn = isbn;
        this.titel = titel;
    }

    public void addExemplar(Exemplar exemplar)
    {
        exemplare.add(exemplar);
    }

    public boolean istVerfuegbar()
    {
        for (Exemplar exemplar : exemplare)
        {
            if (exemplar.getAusleiher() == null)
            {
                return true;
            }
        }

        return false;
    }

    public void removeExemplar(Exemplar exemplar)
    {
        exemplare.remove(exemplar);
    }

    public List<Exemplar> getExemplare()
    {
        return exemplare;
    }

    public int getAusleihDauer()
    {
        return ausleihDauer;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitel()
    {
        return titel;
    }
}
