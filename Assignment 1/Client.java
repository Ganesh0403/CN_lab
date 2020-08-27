import java.net.*;
import java.io.*;

public class Client{
    public static void main(String args[]) throws Exception{
        Socket s = new Socket("localhost",3333);
        String str="", from="";

        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(!from.equals("Exit")){

            System.out.print("\nClient : ");
            str = br.readLine();
            dout.writeUTF(str);
            if(str.equals("Exit"))
                break;
            dout.flush();

            from = din.readUTF();
            System.out.println("\nServer Says : "+ from);
        }
        System.out.println("\nClosing connection");

        dout.flush();
        din.close();
        dout.close();
        s.close();
    }
}