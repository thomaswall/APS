import java.io.*;
import java.util.*;


public class cyclecounter {

	public static long cycles(long number,long counter)
	{
		while(number!=1)
		{
			number = number % 2 != 0 ? (3*number + 1):(number/2);
			counter++;
		}
		return counter;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			int int1 = Integer.parseInt(st.nextToken());
			int int2 = Integer.parseInt(st.nextToken());
			long count = 1;
			long maxcount = 1;
			if(int1<=int2)
			{
				for(long i=int1;i<=int2;i++)
				{
					count = cycles(i,count);

					if(count>maxcount)
					{
						maxcount = count;
					}

					count=1;
				}
			}
			else
			{
				for(long i=int2;i<=int1;i++)
				{
					count = cycles(i,count);

					if(count>maxcount)
					{
						maxcount = count;
					}

					count=1;
				}
			}
			System.out.print(int1+" "+int2+" "+maxcount);
			System.out.println("");
		}
		

	}

}
