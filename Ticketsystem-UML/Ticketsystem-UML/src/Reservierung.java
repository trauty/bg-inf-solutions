public class Reservierung
{
    private static int autonr = 1000;
    private int nummer;
    private DateTime datum;
    private int reihe;
    private int vonPlatz;
    private int bisPlatz;

    private Kunde kunde;
    private Spiel spiel;
    private Block block;

    public Reservierung(Kunde kunde, Spiel spiel, Block block, int reihe, int vonPlatz, int bisPlatz)
    {
        this.kunde = kunde;
        this.spiel = spiel;
        this.block = block;
        this.reihe = reihe;
        this.vonPlatz = vonPlatz;
        this.bisPlatz = bisPlatz;
    }

    public int getNummer() { return nummer; }
    public int getVonPlatz() { return vonPlatz; }
    public int getBisPlatz() { return bisPlatz; }
    public int getReihe() { return reihe; }
    public Block getBlock() { return block; }
}
