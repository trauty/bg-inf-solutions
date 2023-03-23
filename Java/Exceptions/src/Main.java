public class Main {

    public static void main(String[] args)
    {
	    try
        {
            DivisionReader.readAndDivide("tex.txt");
        }
        catch (SillyUser sillyUser)
        {
            sillyUser.printStackTrace();
        }
    }
}
