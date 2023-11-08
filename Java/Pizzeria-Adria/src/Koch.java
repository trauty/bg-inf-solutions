public class Koch extends Thread
{
    private String name;
    private Warteschlange queue;
    public Koch(String name, Warteschlange queue)
    {
        this.name = name;
        this.queue = queue;
    }

    @Override
    public synchronized void run()
    {
        while (true)
        {
            zubereiten(queue.entnehmen());
        }
    }

    private boolean zubereiten(Bestellung b)
    {
        return true;
    }
}
