import java.io.*; 
import java.net.*; 
import java.math.*;
import java.util.*;

public class Server2
{
    public static void main(String[] args) throws IOException
    {
        InetAddress addr = InetAddress.getLocalHost();
        ServerSocket ss = new ServerSocket(4301);
        Socket cnn = ss.accept();

        BufferedInputStream in = new BufferedInputStream(cnn.getInputStream());
        DataOutputStream out = new DataOutputStream(cnn.getOutputStream());

        int p = in.read();
        int pc = in.read();

        boolean f[] = new boolean[p];
        if(pc==0) 
        {
            for(int i=0;i<p;i++)
            {
                System.out.println("\nSending Frame "+i);
                out.write(i);
                System.out.println("Waiting for Acknowledgement...");
                try{
                    Thread.sleep(7000);
                }
                catch(Exception e){}
                int a = in.read();
                System.out.println("Received Acknowledgement for frame "+i+" as "+a);
            }
        }
        else
        {
            for(int i=0;i<p;i++)
            {
                if(i==2)
                {
                    System.out.println("\nSending Frame "+i);
                    System.out.println("Waiting for Acknowledgement...");
                }
                else
                {
                    System.out.println("\nSending Frame "+i);
                    out.write(i);
                    System.out.println("Waiting for Acknowledgement...");
                    try{
                        Thread.sleep(7000);
                    }
                    catch(Exception e){}
                    int a = in.read();
                    if(a!=255)
                    {
                        System.out.println("Received Acknowledgement for frame "+i+" as "+a);
                        f[i] = true;
                    }
                }
            }
            for(int a=0;a<p;a++)
            {
                if(f[a]==false)
                {
                    System.out.println("\nResending Frame "+a);
                    out.write(a);
                    System.out.println("Waiting for Acknowledgement...");
                    try{Thread.sleep(7000);}
                    catch(Exception e){}
                    int b = in.read();
                    System.out.println("Received Acknowledgement for frame "+a+" as "+b);
                    f[a]=true;
                }
            }
        }
        in.close();
        out.close();
        ss.close();
        cnn.close();
    }
}