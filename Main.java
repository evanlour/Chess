import java.net.InetAddress;

public class Main{
    public static void main(String[] args) throws Exception{
        Client client = new Client();
        client.start("localhost", 6666);
        String response = client.sendMessage("Mauros");
        System.out.println("Response");
        client.stopConnection();
    }
}