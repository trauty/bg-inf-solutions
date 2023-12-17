public class BitOps
{
    public static byte setBit(byte b, int pos, boolean value)
    {
        return value ? (byte)(b | (1 << pos)) : (byte)(b & ~(1 << pos));
    }
    public static int setBit(int b, int pos, boolean value)
    {
        return value ? b | (1 << pos) : b & ~(1 << pos);
    }
    public static byte negate(byte b)
    {
        return (byte)~b;
    }
    public static int negate(int b)
    {
        return ~b;
    }
    public static byte or(byte op1, byte op2)
    {
        return (byte)(op1 | op2);
    }
    public static int or(int op1, int op2)
    {
        return op1 | op2;
    }
    public static byte and(byte op1, byte op2)
    {
        return (byte)(op1 & op2);
    }
    public static int and(int op1, int op2)
    {
        return op1 & op2;
    }
    public static byte xor(byte op1, byte op2)
    {
        return (byte)(op1 ^ op2);
    }
    public static int xor(int op1, int op2)
    {
        return op1 ^ op2;
    }
    public static byte shiftLeft(byte b, int pos)
    {
        return (byte)(b << pos);
    }
    public static int shiftLeft(int b, int pos)
    {
        return b << pos;
    }
    public static int shiftRight(int b, int pos)
    {
        return b >> pos;
    }
    public static byte shiftRight(byte b, int pos)
    {
        return (byte)(b >> pos);
    }
}