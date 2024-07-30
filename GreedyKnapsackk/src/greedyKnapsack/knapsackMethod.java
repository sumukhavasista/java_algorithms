 package greedyKnapsack;
import java.util.*;
public class knapsackMethod {
	static int[]p=new int[50];
	static int[]w=new int[50];
	static int[]x=new int[50];
	static int[]t=new int[50];
	static double maxprofit;
	static int n, m, i, j;
	static void dynamicKnapsack(int n, int w[], int p[], int m) {
		int[][]v=new int[n+1][m+1];
		for(i=0;i<n;i++)
			v[i][0]=0;
		
		for(j=0;j<n;j++)
			v[0][j]=0;
		
		for(i=1;i<=n;i++)
			for(j=1;j<=m;j++)
				if(j<w[i])
					v[i][j]=v[i-1][j];
				else
					v[i][j]=max(v[i-1][j], v[i-1][j-w[i]]+p[i]);
		System.out.println("Solution Table: ");
		for(i=0;i<=n;i++) {
			for(j=0;j<=m;j++)
				System.out.println(v[i][j]+"\t");
			System.out.println("\n");
		}
		System.out.println("Optimal Solution for dynamic method"+v[n][m]);
		i=n;
		j=m;
		
		while(i!=0&&j!=0) {
			if(v[i][j]!=v[i-1][j]) {
				x[i]=1;
				j=j-w[i];
			}
			i=i-1;
		}
		System.out.println("The solution vector for Dynamic method is: ");
		for(i=1;i<=n;i++)
			System.out.println(x[i]+"\t");
		System.out.println("\n");
	}
	static int max(int a, int b) {
		return(a>b)?a:b;
	}
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
		
		dynamicKnapsack(n, w, p, m);
		
		for(i=1;i<n;i++)
			x[i]=0;
		
		greedyKnapsack(n, w, p, m);
	}

 
}
