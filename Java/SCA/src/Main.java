import com.fazecast.jSerialComm.SerialPort;

public class Main
{
    public static void main(String[] args)
    {
        SerialPort[] arr = SerialPort.getCommPorts();

        for (SerialPort port : arr)
        {
            System.out.println(port.getDescriptivePortName());
        }
    }
}