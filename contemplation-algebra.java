import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class contemplation-algebra {

	public static long[][] done(int n,long[][] matrix)
	{
		long[][] compare = new long[2][2];
		compare[0][0]=1;
		compare[1][0]=0;
		compare[0][1]=0;
		compare[1][1]=1;
		return power(compare,matrix,n-1);
	}

	public static long[][] power(long[][] compare,long[][] matrix,int n)
	{
		while(n!=0)
		{
			if(n%2!=0)
			{
				compare=multiply(compare,matrix);
			}
			matrix = multiply(matrix,matrix);
			n=n/2;
		}
		return compare;
	}

	public static long[][] multiply(long first[][], long second[][])
	{
		long[][] result = new long[2][2];
	  	result[0][0] =  first[0][0]*second[0][0] + first[0][1]*second[1][0];
	  	result[0][1] =  first[0][0]*second[0][1] + first[0][1]*second[1][1];
	  	result[1][0] =  first[1][0]*second[0][0] + first[1][1]*second[1][0];
	  	result[1][1] =  first[1][0]*second[0][1] + first[1][1]*second[1][1];
	  	return result;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		long p,q;
		int n;
		long[][] matrix;
		long[][] ans;


		while(true)
		{
			st = new StringTokenizer(stdin.readLine());
			p = Long.parseLong(st.nextToken());
			q = Long.parseLong(st.nextToken());
			if(st.hasMoreTokens())
			{
				n = Integer.parseInt(st.nextToken());
			}
			else
			{
				break;
			}
			matrix = new long[2][2];
			matrix[0][0]=p;
			matrix[1][0]=-q;
			matrix[0][1]=1;
			matrix[1][1]=0;
			ans = new long[2][2];
			ans = done(n,matrix);
			if(n==0)
			{
               sb.append(2).append("\n");
            }
            else
            {
            	sb.append(p*ans[0][0]+2*ans[1][0]).append("\n");
            }	

		}
		System.out.print(sb);

		

	}
}
