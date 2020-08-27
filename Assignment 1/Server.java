import java.net.*;
import java.io.*;

public class Server{
    public static void main(String args[]) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        System.out.println("Server Started..");
        System.out.println("Waiting for Client..");
        
        Socket s = ss.accept();
        System.out.println("Client accepted");
        String str = "",to="";

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!to.equals("Exit")){

            str = din.readUTF();
            System.out.println("\nClient Says : "+ str);
            if(str.equals("Exit"))
                break;

            System.out.print("\nServer: ");
            to = br.readLine();
            dout.writeUTF(to);

            dout.flush();
        }
        System.out.println("\nClosing connection");

        
        dout.flush();
        dout.close();
        s.close();
        ss.close();
    }
}