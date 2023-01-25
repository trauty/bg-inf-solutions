public class Block
{
    private static final int REIHEN = 50;
    private static final int PLAETZE = 200;
    private String bezeichnung;
    private boolean[][] belegung = new boolean[REIHEN][PLAETZE];

    public Block(String bezeichnung)
    {
        this.bezeichnung = bezeichnung;
    }

    public boolean istFrei(int reihe, int platz)
    {
        return !belegung[reihe][platz];
    }

    public void belegePlatz(int reihe, int platz)
    {
        belegung[reihe][platz] = true;
    }

    public void gibPlatzFrei(int reihe, int platz)
    {
        belegung[reihe][platz] = false;
    }
    public String getBezeichnung() { return bezeichnung; }
    public boolean[][] getBelegung() { return belegung; }
    public int getReihen() { return REIHEN; }
    public int getPlatze() { return PLAETZE; }
}
