import java.net.*;
import java.io.*;

public class Server extends IOException{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private InetAddress ip;
    public String address;

    public void getIP(){
        try{
            ip = InetAddress.getLocalHost();
            address = ip.getHostAddress();
            System.out.println(address);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }
    }

    public void start(int port){

        try{
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            System.out.println("Does this work?");
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String user = in.readLine();
            out.println("Hello " + user);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void stop(){
        try{
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.start(6666);
        server.getIP();
    }
}
