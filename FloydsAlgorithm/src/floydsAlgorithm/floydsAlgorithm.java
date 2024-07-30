package floydsAlgorithm;
import java.util.*;
public class floydsAlgorithm {
	public static void main(String [] args) {
		int i,j,k,n;
		int [][] a= new int[10][10];
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the no. of nodes");
		n=read.nextInt();
		System.out.println("Enter the cost adjacency matrix,(9999) for no direct path");
			for(i=1;i<=n;i++) {
				for(j=1;j<=n;j++)
					a[i][j]=read.nextInt();
				a[i][i]=0;
			}
			for(k=1;k<=n;k++)
				for(i=1;i<=n;i++)
					for(j=1;j<=n;j++)
						if(a[i][k]+a[k][j]<a[i][j])
							a[i][j]=a[i][k]+a[k][j];
	System.out.println("Output path matrix");
		for(i=1;i<=n;i++){
			for(j=1;j<=n;j++)
				System.out.print(a[i][j]+"\t");
			System.out.println();
		}
	}
}
