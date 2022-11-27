import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class DateTime
{
    private Date crtDate;

    public DateTime()
    {
        crtDate = new Date();
    }

    public DateTime(String date, String time)
    {
        int[] dateParts = Arrays.stream(date.split("[.]")).mapToInt(Integer::parseInt).toArray();
        int[] timeParts = Arrays.stream(time.split("[.]")).mapToInt(Integer::parseInt).toArray();
        crtDate = new Date((dateParts[2] - 1900), dateParts[1] - 1, dateParts[0], timeParts[0], timeParts[1], timeParts[2]);
    }

    public long inMillis()
    {
        return crtDate.getTime();
    }

    public String toString()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss");
        return formatter.format(crtDate);
    }
}
