import java.io.*;
import java.util.*;
import java.math.*;


public class polynomial-solver {

	
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		String newline2;
		StringTokenizer st;
		ArrayList<Long> coefficients = new ArrayList<Long>();
		ArrayList<Long> values = new ArrayList<Long>();
		long sum;
		long n;
		long n2;
		StringBuilder sb = new StringBuilder();
		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			while(st.hasMoreTokens())
			{
				coefficients.add(Long.parseLong(st.nextToken()));
			}

			n = coefficients.size();

			newline2 = stdin.readLine();
			st = new StringTokenizer(newline2);

			while(st.hasMoreTokens())
			{
				values.add(Long.parseLong(st.nextToken()));
			}

			n2 = values.size();

			for(int i=0;i<n2;i++)
			{
				sum=0;

				for(int j=0;j<n;j++)
				{
					sum += (coefficients.get(j)*Math.pow(values.get(i),(n-j-1)));
				}

				sb.append(sum);
				if(i!=n2-1)
				{
					sb.append(" ");
				}
					
			}

			coefficients.clear();
			values.clear();
			System.out.println(sb);
			sb.setLength(0);
		}
		

	}

}
