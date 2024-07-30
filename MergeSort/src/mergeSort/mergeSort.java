package mergeSort;
import java.util.*;
import java.io.*;
public class mergeSort {
	static int[]a;
	static int n;
	static boolean flag=true;
	
	static void mergeSort(int a[], int low, int high) {
		int mid;
		if(low<high) {
			mid=(low+high)/2;
			
			mergeSort(a, low, mid);
			mergeSort(a, mid+1, high);
			mergeSort(a, low, mid, high);
		}
	}
	static void mergeSort(int a[], int low, int mid, int high) {
		int i1, i2, j, k;
		int[]b=new int[n];
		
		i1=j=low;
		i2=mid+1;
		
		if(flag) {
			while((i1<=mid)&&(i2<=high)) {
				if(a[i1]<=a[i2]) {
					b[j]=a[i1];
					i1++;
				}
				else {
					b[j]=a[i2];
					i2++;
					
				}
				j++;
			}
			if(i1>mid)
				for(k=i2;k<=high;j++,k++)
					b[j]=a[k];
			else
				for(k=i1;k<=mid;j++,k++)
					b[j]=a[k];
			for(k=low;k<=high;k++)
				a[k]=b[k];
		}
		else {
			while((i1<=mid)&&(i2<=high)) {
				if(a[i1]>=a[i2]) {
					b[j]=a[i1];
					i1++;
				}
				else {
					b[j]=a[i2];
					i2++;
				}
				j++;
			}
			if(i1>mid)
				for(k=i2;k<=high;j++,k++)
					b[j]=a[k];
			else
				for(k=i1;k<=mid;k++,k++)
					b[j]=a[k];
			for(k=low;k<=high;k++)
				a[k]=b[k];
		}
	}
	public static void main(String[]args)throws IOException {
		int i;
		long st, et;
		
		Scanner read=new Scanner(System.in);
		Random random=new Random();
PrintWriter out=new PrintWriter(new File("Random.txt"));
System.out.println("Enter the number of elements greater than 5000");
n=read.nextInt();
a=new int[n];
for(i=0;i<n;i++) {
	a[i]=random.nextInt(n)+1;
	out.print(a[i]+"\t");
}
System.out.println("The total numbers generated: "+i);
out.close();

st=System.nanoTime();
mergeSort(a, 0, n-1);
et=System.nanoTime() -st;

PrintWriter outA=new PrintWriter(new File("Ascending.txt"));
for(i=0;i<n;i++)
	outA.print(a[i]+"\t");
outA.close();
System.out.println("Tge time complexity for worst case is..."+(et/1000000000.0)+"seconds");
st=System.nanoTime();
mergeSort(a, 0, n-1);
et=System.nanoTime() -st;
System.out.println("The time complexity for best case is..."+(et/1000000000.0)+"seconds");
flag=false;
st=System.nanoTime();
mergeSort(a, 0, n-1);
et=System.nanoTime() -st;

PrintWriter outD=new PrintWriter(new File("Descending.txt"));
for(i=0;i<n;i++)
	outD.print(a[i]+"\t");
outD.close();
System.out.println("The time complexity for average case is..."+(et/1000000000.0)+"seconds");

	}

}
