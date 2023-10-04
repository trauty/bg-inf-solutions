import socketio.*;

// nicht getestet

import java.io.IOException;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket socket = new Socket("127.0.0.1", 42060);

        socket.connect();

        Scanner input = new Scanner(System.in);

        System.out.println(socket.readLine());

        while (true)
        {
            socket.write(input.nextLine() + "\n");
            System.out.println(socket.readLine());
        }
    }
}
