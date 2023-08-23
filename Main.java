import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception{
        Client client = new Client();
        Scanner messageInput = new Scanner(System.in);
        System.out.println("Welcome, please give us your username!");
        String clientName = messageInput.nextLine();
        client.setName(clientName);
        client.start("localhost", 6666);
        String message = "";
        while(!message.equals("EXIT")){
            message = messageInput.nextLine();
            String response = client.sendMessage(message);
            System.out.println(response);
        }
        
        messageInput.close();
        client.stopConnection();
    }
}