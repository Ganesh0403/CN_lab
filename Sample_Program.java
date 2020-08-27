import java.util.Scanner;
import java.util.ArrayList;

class Student
{
    String name;
    int roll_no;
    String grade;
    double avg;
    double marks[] = new double[5];

    public Student()
    {
        this.avg = 0;
    }
    public void accept()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Name of Student : ");
        this.name = sc.nextLine();
        System.out.print("Enter Roll Number of Student : ");
        this.roll_no = sc.nextInt();

        System.out.println("\nEnter marks for 5 subjects (out of 100): \n");
        for(int i=1;i<6;i++)
        {
            System.out.print("Enter marks for subject "+i+" : ");
            this.marks[i-1] = sc.nextDouble();
            this.avg += this.marks[i-1];
        }
    }
    public void calculate()
    {
        double percent = this.avg*100/500;
        if(percent>75)
            this.grade = "First Class";
        else if(percent>60)
            this.grade = "Second Class";
        else if(percent>40)
            this.grade = "Pass";
        else
            this.grade = "Fail";

        System.out.println("\n"+this.name + " has Grade " + this.grade + " with Percentage: "+percent + "%\n");
    }
} 

public class Sample_Program
{
    public static void main(String args[])
    {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> usersList = new ArrayList<Student>();
        System.out.print("Enter the count of Student : ");
        count = sc.nextInt();

        System.out.println("\nEnter Student Details of "+ count + " students\n");
        for (int i=0;i<count;i++)
        {
            Student student = new Student();
            student.accept();
            student.calculate();
            usersList.add(student);
        }
    }
}