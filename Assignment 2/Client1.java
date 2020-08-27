import java.net.*;
import java.io.*;

public class Client1 {

    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
    public static void main(String args[]) throws Exception{
        InetAddress ip = InetAddress.getLocalHost();
        DatagramSocket s = new DatagramSocket(1034);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        byte [] buf = null;
        String str = "", str1 = "";

        while(!str1.equals("Exit")){
            System.out.print("\n\nClient: ");
            str = br.readLine();
            buf = str.getBytes();

            DatagramPacket p2 = new DatagramPacket(buf, buf.length, ip, 4301);
            s.send(p2);
            if(str.equals("Exit"))
                break;

            byte [] buf1 = new byte[555];
            
            DatagramPacket p1 = new DatagramPacket(buf1, buf1.length);
            s.receive(p1);
            buf1 = p1.getData();
            
            str1 = data(buf1).toString();
            System.out.print("\nServer says: "+str1);
        }
    }
}