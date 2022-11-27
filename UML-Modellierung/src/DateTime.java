import java.time.LocalDateTime;
import java.util.Date;

public class DateTime
{
    private DateTime crtTime;

    public DateTime()
    {
        crtTime = LocalDateTime.now();
    }

    public DateTime(String date, String time)
    {
        String[] dateParts = date.split("[.]");
        String[] timeParts = time.split("[.]");
        Date yes = new Date((dateParts[0]), dateParts[1], dateParts[2], timeParts[3], dateParts[4], dateParts[5]);
    }

    public long inMillis()
    {

    }

    public String toString()
    {

    }
}
