public class Sort 
{
    public static void bubblesort(int[] werte)
    {
        for (int i = 0; i < werte.length - 1; i++)
        {
            for (int j = 0; j < werte.length - 1; j++)
            {
                if (werte[j] > werte[j + 1])
                {
                    int buf = werte[j];
                    werte[j] = werte[j + 1]; // Swap
                    werte[j + 1] = buf;
                }
            }
        }
    }

    public static void selectionsort(int[] werte)
    {
        for (int i = 0; i < werte.length - 1; i++)
        {
            int min = i;

            for (int j = i + 1; j < werte.length; j++)
            {
                if (werte[j] < werte[min]) { min = j; }
            }

            int buf = werte[min]; 
            werte[min] = werte[i]; // Swap
            werte[i] = buf;
        }
    }

    public static void insertionsort(int[] werte)
    {
        for (int i = 0; i < werte.length; i++)
        {
            int cur = werte[i];
            int j = i - 1;

            while (j >= 0 && werte[j] > cur)
            {
                werte[j + 1] = werte[j];
                j -= 1;
            }

            werte[j + 1] = cur;
        }
    }
}
