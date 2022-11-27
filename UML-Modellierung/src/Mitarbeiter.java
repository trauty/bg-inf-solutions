import java.util.List;

public class Mitarbeiter
{
    private String name;
    private String email;
    private String passwort;

    private List<Ticket> meineTickets;

    public Mitarbeiter(String name, String email, String passwort)
    {
        this.name = name;
        this.email = email;
        this.passwort = passwort;
    }

    public void zuordnenTicket(Ticket ticket)
    {
        meineTickets.add(ticket);
    }
}
