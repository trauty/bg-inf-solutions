import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DivisionReader
{
    static int firstDigit = 0;
    static int secondDigit = 0;

    public static void readAndDivide(String fileName) throws SillyUser
    {
        try(BufferedReader bufRd = new BufferedReader(new FileReader(fileName)))
        {
            firstDigit = Integer.parseInt(bufRd.readLine());
            secondDigit = Integer.parseInt(bufRd.readLine());
            System.out.println(firstDigit / secondDigit);
            System.out.println("done");
        }
        catch(FileNotFoundException exc)
        {
            System.out.println("Die Datei wurde nicht gefunden:");
            exc.printStackTrace();
            System.out.println("done");
            throw new SillyUser("YOU ARE A DUMB ONE, AREN'T YOU?");
        }
        catch (IOException exc)
        {
            System.out.println("Es ist ein Fehler aufgetreten:");
            exc.printStackTrace();
            System.out.println("done");
            throw new SillyUser("YOU ARE A DUMB ONE, AREN'T YOU?");
        }
        catch (ArithmeticException exc) //Aufgabe 5: Die Exception muss explizit gefangen werden
        {
            System.out.println("Mathematischer Fehler:");
            exc.printStackTrace();
            System.out.println("done");
            throw new SillyUser("YOU ARE A DUMB ONE, AREN'T YOU?");
        }
    }
}
