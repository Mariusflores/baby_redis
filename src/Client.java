import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 6379);

            DataOutputStream d = new DataOutputStream(
                    s.getOutputStream()
            );

            // message to be displayed
            d.writeUTF("Hello World");

            // Flushing out internal buffers
            // Optimizing for better performance
            d.flush();

            // Closing connections

            // Closing DataOutputStream
            d.close();
            //Closing socket
            s.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
