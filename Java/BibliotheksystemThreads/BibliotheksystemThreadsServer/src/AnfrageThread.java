import socketio.Socket;

import java.io.IOException;

// nicht getestet
public class AnfrageThread implements Runnable
{
    private Socket clientSocket;
    private Bibliothekssystem sys;

    public AnfrageThread(Socket clientSocket, Bibliothekssystem sys)
    {
        this.clientSocket = clientSocket;
        this.sys = sys;
    }

    @Override
    public void run()
    {
        try
        {
            clientSocket.write("+OK BibServer\n");

            String anfrage = "";

            while (!anfrage.equals("quit"))
            {
                anfrage = clientSocket.readLine();
                if (anfrage.contains("ausleihen"))
                {
                    String[] anfragenInhalt = anfrage.split(" ");

                    Leser leser = sys.sucheLeser(Integer.parseInt(anfragenInhalt[1]));
                    Exemplar exemplar = sys.sucheExemplar(anfragenInhalt[3]);

                    int status = sys.ausleihen(leser, exemplar);

                    if (status == 0)
                    {
                        clientSocket.write("+OK Ausleihe erfolgt\n");
                    }
                    else
                    {
                        clientSocket.write("-ERR Ausleihe nicht erfolgt\n");
                    }
                }
                else
                {
                    clientSocket.write("-ERR unbekanntes Kommando\n");
                }
            }

            clientSocket.write("+OK bye\n");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
