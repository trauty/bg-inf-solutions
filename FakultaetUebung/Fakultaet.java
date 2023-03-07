public class Fakultaet
{
    public static long fakRek(long n)
    {
        if (n == 0) { return 1; }
        return n * fakRek(n - 1);
    }

    public static long fakIter(long n)
    {
        long buf = 1;
        for (long i = 2; i <= n; i++)
        {
            buf *= i;
        }

        return buf;
    }
}