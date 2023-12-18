public class Main
{
    public static void main(String[] args)
    {
        test((byte)41);
    }

    private static void test(byte testwert)
    {
        ausgabe("setBit(byte b, int pos, boolean value)", BitOps.setBit(testwert, 1, true) == 43);
        ausgabe("setBit(int b, int pos, boolean value)", BitOps.setBit((int)testwert, 2, true) == 45);
        ausgabe("negate(byte b)", BitOps.negate(testwert) == -42);
        ausgabe("negate(int b)", BitOps.negate((int)testwert) == -42);
        ausgabe("or(byte op1, byte op2)", BitOps.or(testwert, (byte)0b1111111) == 127);
        ausgabe("or(int op1, int op2)", BitOps.or(testwert, 0b1111111) == 127);
        ausgabe("and(byte op1, byte op2)", BitOps.and(testwert, (byte)0b1010101) == 1);
        ausgabe("and(int op1, int op2)", BitOps.and(testwert, 0b1010101) == 1);
        ausgabe("xor(byte op1, byte op2)", BitOps.xor(testwert, (byte)0b1010101) == 124);
        ausgabe("xor(int op1, int op2)", BitOps.xor(testwert, 0b1010101) == 124);
        ausgabe("shiftLeft(byte b, int pos)", BitOps.shiftLeft(testwert, 1) == 82);
        ausgabe("shiftLeft(int b, int pos)", BitOps.shiftLeft(testwert, 1) == 82);
        ausgabe("shiftRight(int b, int pos)", BitOps.shiftRight(testwert, 1) == 20);
        ausgabe("shiftRight(byte b, int pos)", BitOps.shiftRight(testwert, 1) == 20);
    }

    private static void ausgabe(String methode, boolean bestanden)
    {
        System.out.println(methode + " | Bestanden: " + (bestanden ? "Ja" : "Nein"));
    }
}