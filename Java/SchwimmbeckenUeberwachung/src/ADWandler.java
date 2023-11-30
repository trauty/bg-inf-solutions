import serialio.Serial;

public class ADWandler
{
    Serial serial = new Serial("COM1", 9600, 8, 1, 0);
    public int liesWert()
    {
        if (serial.open())
        {
            serial.setRTS(false);
            serial.setDTR(false);

            int wert = 0;

            for (int i = 0; i < 8; i++)
            {
                serial.setRTS(true);
                serial.setRTS(false);
                if (serial.isCTS())
                {
                    wert += (int)Math.pow(2, i);
                }
            }

            serial.setDTR(true);

            serial.close();

            return wert < 190 ? -99 : wert;
        }
        else
        {
            return -99;
        }
    }
}
