public class Main
{
    public static void main(String[] args)
    {
        Biene biene = new Biene();
        Fledermaus fledermaus = new Fledermaus();
        Flugzeug flugzeug = new Flugzeug();
        abflug(biene);
        abflug(fledermaus);
        abflug(flugzeug);
    }

    private static void abflug(Fliegen fliegenInterface)
    {
        fliegenInterface.fliegen();
    }
}
