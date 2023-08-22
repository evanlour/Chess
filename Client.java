import java.io.*;
import java.net.*;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void start(String ip, int port) throws Exception{
        clientSocket = new Socket("localhost", 6666);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String message) throws Exception{
        out.println(message);
        String resp = in.readLine();
        return resp;
    }

    public void stopConnection() throws Exception{
        in.close();
        out.close();
        clientSocket.close();
    }
}
