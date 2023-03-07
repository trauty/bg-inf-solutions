public class Main
{
    public static void main(String[] args) 
    {
        int[] werte1 = { 1, 5, 8, 2, 7, 4};
        Sort.bubblesort(werte1);
        printArr(werte1);

        int[] werte2 = { 1, 15, 8, 2, 66, 4};
        Sort.selectionsort(werte2);
        printArr(werte2);

        int[] werte3 = { 19, 22, 10044, 90909, 456, 2};
        Sort.insertionsort(werte3);
        printArr(werte3);
    }

    private static void printArr(int[] werte)
    {
        for (int i = 0; i < werte.length; i++) 
        {
            System.out.print(werte[i] + ", ");
        }

        System.out.println("\n");
    }
}