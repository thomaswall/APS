import java.io.*;
import java.util.*;
import java.math.*;

public class benefit {

public static long gcd(long a, long b) 
{
   if (b==0)
   {
    	return a;
   }
   return gcd(b,a%b);
}
	

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		long A;
		long C;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			A = Long.parseLong(st.nextToken());
			C = Long.parseLong(st.nextToken());
			boolean checker = false;
			long j=C/A;


			if(C%A==0)
			{
				checker=true;
				while(j/gcd(A,j)!=C/A)
				{
					j+=C/A;
				}
			}
			if(checker==true)
			{
				sb.append(j).append("\n");
			}
			else
			{
				sb.append("NO SOLUTION\n");
			}


		}
		System.out.print(sb);
	}

}
