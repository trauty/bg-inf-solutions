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

    public void ueberwache() throws InterruptedException {
        while (true)
        {
            Thread.sleep((long) intervall * 1000 * 60);
            int unterSollwert = 0;

            for (ADWandler w : wandler)
            {
                if(inCelsius(w.liesWert()) < sollTemp)
                {
                    unterSollwert++;
                }
            }

            switch (unterSollwert)
            {
                case 1:
                    alarm = "gruen";
                    break;

                case 2:
                    alarm = "orange";
                    heizung.aendereLeistung(1);
                    intervall = 5;
                    break;

                case 3:
                    alarm = "rot";
                    heizung.aendereLeistung(3);
                    intervall = 5;
                    break;

                default:
                    alarm = "gruen";
                    heizung.aendereLeistung(0);
                    intervall = 10;
                    break;
            }
        }
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
            wert = -(1 / 3) * d + 90;
        }

        return wert;
    }

    public String getAlarm()
    {
        return alarm;
    }
}
