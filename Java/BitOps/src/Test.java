public class Test
{
    public Test(byte testwert)
    {
        System.out.println("Methode: byte setBit(byte b, int pos, boolean value) mit pos = 3 und value = true; Testwert: " + Integer.toBinaryString(testwert) + ", Ergebnis: " + Integer.toBinaryString(BitOps.setBit(testwert, 3, true)));
    }
}
