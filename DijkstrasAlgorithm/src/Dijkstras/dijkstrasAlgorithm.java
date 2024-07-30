package Dijkstras;
import java.util.*;
public class dijkstrasAlgorithm {
	static void shortest(int v,int cost[][],int dist[],int n){
	boolean [] s = new boolean[10];
	int i,w,u,num;
	for(i=1;i<=n;i++) {
		s[i]=false;
		dist[i]=cost[v][i];
	}
	
		s[v]=true;
		dist[v]=0;
		num=2;
		while(num<=n) {
			u=choose(dist,s,n);
			s[u]=true;
			num++;
			for(w=1;w<=n;w++) {

				if(((dist[u]+cost[u][w])<dist[w])&&!s[w])
				dist[w]=dist[u]+cost[u][w];

			}
		}
	}
	static int choose(int dist[],boolean s[],int n) {
		int w,j=0,min=9999;
		for(w=1;w<=n;w++)
		if((dist[w]<min)&&(s[w]==false)) {
			min=dist[w];
			j=w;
	}
	return j;
	}
	public static void main(String [] args) {
	int [][]cost = new int[50][50];
	int []dist = new int[50];
	int i,j,n,v;
	Scanner read=new Scanner(System.in);
	System.out.println("enter the no. of nodes:");
	n=read.nextInt();
	System.out.println("enter the cost adjacency matrix,'9999' for no direct path\n");
			for(i=1;i<=n;i++)
			for(j=1;j<=n;j++)
			cost[i][j]=read.nextInt();

			System.out.println("enter the starting vertex:");
			v=read.nextInt();
			shortest(v,cost,dist,n);
			System.out.println("Shortest path from starting vertex to other vertices are ");

			for(j=1;j<=n;j++)
			System.out.println(v+"->"+j+"="+dist[j]);

			}
	}

