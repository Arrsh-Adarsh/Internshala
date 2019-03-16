# Internshala
Java Project
import java.util.*;

class Data
{
    String name;
    double CGPA;
    int token;
    
    public Data(String name,float CGPA,int token)                   //constructor
    {
        this.name=name;
        this.CGPA=CGPA;
        this.token=token;
    }
    
    public String getname()
    {
        return name;
    }
    public double getCgpa()
    {
        return CGPA;
    }
    public int getToken()
    {
        return token;
    }
}

public class Demo {   
    
 //MAIN FUNCTION STARTS HERE
    
     public static void main(String args[])
    {
        int a=0;
        Scanner Sc=new Scanner(System.in);
        int n=Integer.parseInt(Sc.nextLine());
        PriorityQueue<Data> Student = new PriorityQueue(Comparator.comparing(Data::getCgpa).reversed().thenComparing(Data::getname).thenComparing(Data::getToken));
       
 // TAKING INPUT FROM USER       
        while(n-- >0)
        {  
            String event=Sc.nextLine();
            
            String eventarr[]=event.split(" ");
            
            if(eventarr[0].equals("ENTER"))
            {
                String name=eventarr[1];
                float CGPA=Float.parseFloat(eventarr[2]);
                int token=Integer.parseInt(eventarr[3]);
                
                Data d=new Data(name,CGPA,token);
                Student.add(d);
               
            }
            else if(eventarr[0].equals("SERVED"))
            {
                Data Head=Student.poll();
            }
        }    
        
 // OUTPUT STARTS FROM HERE       
        
        Data Head=Student.poll();
        if(Head==null)
        {
            System.out.println("EMPTY");
        }        
        else
        {
            while(Head!=null)
            {
                System.out.println(Head.name);
                Head=Student.poll();
            }
        }
    }
}
