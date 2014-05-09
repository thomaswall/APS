import java.io.*;
import java.util.*;
import java.math.*;

public class frosh-week {
	static int[] students;
	static int[] students2;
	static long inversions;

	public static void mergesort(int index1, int index2)
	{
		if(index1<index2)
		{
			int middle = (index1+index2)/2;
			mergesort(index1,middle);
			mergesort(middle+1,index2);
			merge(index1,middle,index2);
		}
	}

	public static void merge(int first,int middle,int last)
	{
		for(int i=first;i<=last;i++)
		{
			students2[i]=students[i];
		}
		int i = first;
    	int j = middle + 1;
    	int k = first;
		while(i<=middle && j<=last)
		{
			if(students2[i]<=students2[j])
			{
				students[k] = students2[i];
				i++;
			}
			else
			{
				students[k]=students2[j];
				inversions+=(middle-i+1);
				j++;
			}
			k++;
		}
		while(i<=middle)
		{
			students[k]=students2[i];
			k++;
			i++;
		}
	}


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		int kids;
		int temp;


		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			kids = Integer.parseInt(st.nextToken());
			students = new int[kids];
			students2 = new int[kids];
			inversions=0;

			for(int i=0;i<kids;i++)
			{
				st = new StringTokenizer(stdin.readLine());
				temp = Integer.parseInt(st.nextToken());
				students[i]=temp;
				students2[i]=temp;
			}
			mergesort(0,students.length-1);
			sb.append(inversions).append("\n");


		}
		System.out.print(sb);

		

	}
}
