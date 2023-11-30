public class Steuerung
{
    private int sollTemp;
    private int intervall = 10;
    private String alarm = "gruen";

    Heizung heizung = new Heizung();
    ADWandler[] wandler = null;

    public Steuerung(int sollTemp)
    {
        this.sollTemp = sollTemp;
    }

    public void ueberwache()
    {

    }

    public static int inCelsius(int d)
    {
        int wert = 0;

        if (d > 210)
        {
            wert = -d + 230;
        }
        else
        {
            wert = (-1 / 3) * d + 90;
        }

        return wert;
    }

    public String getAlarm()
    {
        return alarm;
    }
}
