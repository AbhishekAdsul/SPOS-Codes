package FCFS;

import java.util.*;

public class FCFS{
    public static void main(String args[])
    {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("________________________________________________________");
        System.out.println("|SPOS Practical           |       CPU Scheduling       |");
        System.out.println("|______________________________________________________|");
        System.out.println("|           First Come First Surved (FCFS)             |");
        System.out.println("|______________________________________________________|\n");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int pid[]=new int[n];  //process ids
        int ar[]=new int[n];   //arrival time
        int bt[]=new int[n];   //burst time , CPU time
        int ct[]=new int[n];   //completion time , finish time
        int ta[]=new int[n];   //tarnaround time
        int wt[]=new int[n];   //waiting time
        int temp;
        float avgta=0,avgwt=0;

        //Taking input one by one for arrival time and burst time
        for(int i=0;i<n;i++)
        {
            System.out.print("\nEnter process "+(i+1)+" arrival time: ");
            ar[i]=sc.nextInt();
            System.out.print("\nEnter process "+(i+1)+" burst time: ");
            bt[i]=sc.nextInt();
            pid[i]=i+1;
        }

        //sorting according to arrival time
        for(int i=0;i<n;i++)
        {
            for(int j=0;j< n-(i+1);j++)
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

        //finding completion times
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
            ta[i]=ct[i]-ar[i];  //turnaround time = completion time - arrival time
            wt[i]=ta[i]-bt[i];  //waiting time = turnaround time -burst time
            avgta=avgta+ta[i];  //average turnaround time 
            avgwt=avgwt+wt[i];  //average waiting time
        }

        //Display Output
        System.out.print("\n_________________________________________________________________________________________");
        System.out.println("\n|ProcessId | ArrivalTime | BurstTime | CompletionTime | TurnaroundTime | WaitingTime\t|");
        for(int i=0;i<n;i++)
        {
                System.out.println("|"+pid[i]+"\t\t"+ar[i]+"\t\t"+bt[i]+"\t\t"+ct[i]+"\t\t"+ta[i]+"\t\t"+wt[i]+"\t|");
        }
        System.out.print("|_______________________________________________________________________________________|\n");
        sc.close();
        System.out.println("\nAverage turnaround time: "+(avgta/n)+"\n"); 
        System.out.println("Average waiting time: "+(avgwt/n)+"\n\n");  
        }
}
