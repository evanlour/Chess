import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Server extends IOException{
    private ServerSocket serverSocket;
    private static ArrayList<Socket> clientSockets = new ArrayList<Socket>();

    public void start(int port){
        try{
            serverSocket = new ServerSocket(port);
            while(true){
                new EchoClientHandler(serverSocket.accept()).start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static class EchoClientHandler extends Thread{
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket){
            this.clientSocket = socket;
            clientSockets.add(socket);
        }

        public void run(){
            try{
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while((inputLine = in.readLine()) != null){
                    if("EXIT".equals(inputLine)){
                        out.println("Disconnection");
                        break;
                    }
                    out.println(inputLine);
                }
                
                in.close();
                out.close();
                clientSocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        Server server = new Server();
        server.start(6666);
    }

}
