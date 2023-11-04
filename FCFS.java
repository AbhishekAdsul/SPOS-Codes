import java.util.*;

public class FCFS {
    public static void main(String args[])
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int pid[]=new int[n];
        int ar[]=new int[n];
        int bt[]=new int[n];
        int ct[]=new int[n];
        int ta[]=new int[n];
        int wt[]=new int[n];
        int temp;
        float avgwt=0,avgta=0;
        

        //input arrival time and burst time one by one
        for(int i=0;i<n;i++)
        {
            System.out.print("Enter process number "+(i+1)+"arrival time: ");
            ar[i]=sc.nextInt();
            System.out.print("Enter process number "+(i+1)+" burst time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }

        //sorting according to arrival time
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-(i+1);j++)
            {
                if(ar[j]>ar[j+1])
                {
                    temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;

                    temp=bt[j];
                    bt[j]=bt[j+1];
                    bt[j+1]=temp;

                    temp=pid[j];
                    pid[j]=pid[j+1];
                    pid[j+1]=temp;

                }
                
                
            }

        }

        //colculating completion time
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                ct[i]=ar[i]+bt[i];
            }
            else
            {
                if(ar[i]>ct[i-1])
                {
                ct[i]=ar[i]+bt[i];
                }
                else
                {
                ct[i]=ct[i-1]+bt[i];
                }
            }
            ta[i]=ct[i]-ar[i];
            wt[i]=ta[i]-bt[i];
            avgta=avgta+ta[i];
            avgwt=avgwt+wt[i];
        }

        //display output        
        System.out.print("\n_________________________________________________________________________________________");
        System.out.println("\n|ProcessId | ArrivalTime | BurstTime | CompletionTime | TurnaroundTime | WaitingTime\t|");
        for(int i=0;i<n;i++)
        {
                System.out.println("|"+pid[i]+"\t\t"+ar[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]+"\t|");
        }
        System.out.print("|_______________________________________________________________________________________|\n");

        System.out.println("Average tarnaround time: "+(avgta/n)+"\n");
        System.out.println("Average waiting time: "+(avgwt/n)+"\n");

        

    } 
}    


