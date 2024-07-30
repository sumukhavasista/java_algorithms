package greedyKnapsack;
import java.util.*;
import java.io.*;
public class greedyKnapsack {
	static int[]p=new int[50];
	static int[]w=new int[50];
	static int[]x=new int[50];
	static int[]t=new int[50];
	static double maxprofit;
	static int n, m, i, j;
	static void greedyKnapsack(int n, int w[], int p[], int m) {
		int rc=m;
		
		bubbleSort(n, w, p, t);
		
		for(i=1;i<=n;i++) {
			if(w[t[i]]>rc)
				continue;
			
			x[t[i]]=1;
			rc-=w[t[i]];
			maxprofit+=p[t[i]];
			
		}
		System.out.println("Optimal solution for greedy method: "+maxprofit);
		System.out.println("Solution vector for greedy method: ");
		for(i=1;i<=n;i++)
			System.out.println(x[i]+"\t");
	}
	static void bubbleSort(int n, int w[], int p[], int t[]) {
		int temp;
		
		for(i=1;i<=n;i++)
			t[i]=1;
		
		for(i=1;i<n;i++)
			for(j=1;j<n;j++)
				if((double)p[t[j]]/w[t[j]]<(double)p[t[j+1]]/w[t[j+1]]) {
					temp=t[j];
					t[j]=t[j+1];
					t[j+1]=temp;
				}
				
	}
	public static void main(String[]args) {
		Scanner read=new Scanner (System.in);
		
		System.out.println("Enter the number of objects: ");
		n=read.nextInt();
		
		System.out.println("enter the object's weight: ");
		for(i=1;i<=n;i++)
			w[i]=read.nextInt();
		
		System.out.println("Enter the object's profits: ");
		for(i=1;i<=n;i++)
			p[i]=read.nextInt();
		
		System.out.println("Enter the maximum capacity: ");
		m=read.nextInt();
		for(i=1;i<n;i++)
		x[i]=0;
	
	greedyKnapsack(n, w, p, m);
		}


	}

