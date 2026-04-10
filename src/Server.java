import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Starting server...");

        try {

            // Create a ServerSocket listening on port 6379
            ServerSocket ss = new ServerSocket(6379);

            System.out.println("Server started listening on port 6379... ");

            // Accept a connection from a client
            Socket s = ss.accept();
            System.out.println("Client connected");

            // Read message from the client
            DataInputStream d = new DataInputStream(s.getInputStream());
            String str = d.readUTF();
            System.out.println("message: " + str);

            // Close socket
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
