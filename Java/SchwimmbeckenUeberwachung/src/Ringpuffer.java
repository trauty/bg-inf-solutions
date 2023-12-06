public class Ringpuffer
{
    private int counter = 0;
    Messung[] messungen = null;
    public Ringpuffer(int groesse)
    {
        messungen = new Messung[groesse];
    }

    public void schreibeMessung(Messung messung)
    {
        messungen[++counter % messungen.length] = messung;
        counter++;
    }

    public Messung[] liesMessungen()
    {
        Messung[] rueckgabe = new Messung[messungen.length];
        int curCounter = counter;

        for (int i = 0; i < (counter < messungen.length ? curCounter : messungen.length); i++)
        {
            rueckgabe[i] = messungen[curCounter-- % messungen.length];
        }

        return rueckgabe;
    }
}
