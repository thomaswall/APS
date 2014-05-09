import java.io.*;
import java.util.*;
import java.math.*;

public class jimmys-balls {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String newline;
		StringBuilder sb = new StringBuilder();
		long n;
		long max;
		long sum;
		long temp1;
		long temp2;
		int cases=1;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			if((n = Integer.parseInt(st.nextToken()))!=0)
			{
				max=n/3-1;
				sum =0;

				for(long i=max;i>0;i--)
				{
					temp1 = i+1;
					temp2 = n-i-temp1;
					sum+=(long)Math.ceil((temp2-temp1)/2.0);
				}
				sb.append("Case ").append(cases).append(": ").append(sum).append("\n");
				cases++;
			}

		}
		System.out.print(sb);
	}

}
