import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;

public class Arduino {
    private SerialPort sp;
    private String userPort = "COM4";
    private Scanner sc;

    Arduino() {
        //COM4
        sp = SerialPort.getCommPort(userPort);
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING,0,0);
        if(!this.sp.openPort()){
            throw new RuntimeException("Port not Found");
        }
        sc = new Scanner(this.sp.getInputStream());
    }

    public String readArduino(){
        return sc.nextLine();
    }

    public SerialPort[] getCommPorts(){
        return SerialPort.getCommPorts();
    }

    public void setUserPort(String port){
        this.userPort = port;
    }

    public String getUserPort(){
        return this.userPort;
    }

    public void closePort(){
        this.sp.closePort();
        this.sc.close();
    }
}
