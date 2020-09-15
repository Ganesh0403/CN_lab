import java.io.*; 
import java.net.*; 
import java.math.*;
import java.util.*;
  
public class Client2
{
    public static void main(String args[]) throws IOException
    {
        InetAddress addr = InetAddress.getLocalHost();
        Socket conn = new Socket(addr,4301);

        BufferedInputStream in = new BufferedInputStream(conn.getInputStream());
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter No of frames: ");
        int c = sc.nextInt();
        out.write(c);
        System.out.print("\nEnter type of transmission(error-1, errorless-0): ");
        int choice = sc.nextInt();
        out.write(choice);

        int check=0,i=0,j=0;
        if(choice==0)  
        {
            for(j=0;j<c;j++)
            {
                i = in.read();
                System.out.println("\nReceived Frame "+i);
                System.out.println("Sending Acknowledgement "+i);
                out.write(i);
            }
        }
        else 
        {
            for(j=0;j<c;j++)
            {
                i = in.read();
                if(i==check)
                {
                    System.out.println("\nReceived Frame "+i);
                    System.out.println("Sending Acknowledgement "+i);
                    out.write(i);
                    check++;
                }
                else
                {
                    j--;
                    System.out.println("\nDiscard frame "+i);
                    System.out.println("Sending Negative Acknowledgement "+i);
                    out.write(-1);
                }
            }
        }
        in.close();
        out.close();
        conn.close();
    }
}