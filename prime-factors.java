import java.io.*;
import java.util.*;
import java.math.*;

public class prime-factors {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String newline;
		StringBuilder sb = new StringBuilder();
		boolean[] sieve = new boolean[1<<16+1];
		Arrays.fill(sieve,true);
		long number;
		sieve[0]=false;
		sieve[1]=false;
		ArrayList<Long> primes = new ArrayList<Long>();
		for(int i=2;i<=(1<<16);i++)
		{
			if(sieve[i]==true)
			{
				primes.add((long)i);
				int j=2;
				while(i*j<=(1<<16))
				{
					sieve[i*j]=false;
					j++;
				}
			}
		}

		while((newline=stdin.readLine())!=null)
		{
				st = new StringTokenizer(newline);
				number = Long.parseLong(st.nextToken());
				if(number!=0)
				{
				sb.append(number).append(" =");
				boolean negative=false;
				boolean first = true;
				if(number<0)
				{
						number = -number;
						sb.append(" -1");
						negative = true;
						first = false;
				}
				else if(number==1)
				{
					sb.append(" 1");
				}
				int i=0;
				long temp=0;
				long yes=number;
				while(number!=1 && temp<=Math.sqrt(yes) && i<primes.size())
				{
						temp = primes.get(i);
						if(number%temp==0)
						{	
							if(first==false)
							{
								sb.append(" x ").append(temp);
								number=number/temp;
							}
							else
							{
								sb.append(" ").append(temp);
								number=number/temp;
								first = false;
							}
						}
						else
						{
							i++;
						}
				}

				if(number>1)
				{
					if(number!=yes)
					{
						sb.append(" x ").append(number);
					}
					else
					{
						if(negative==false)
						{
							sb.append(" ").append(number);
						}
						else
						{
							sb.append(" x ").append(number);
						}
					}
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

}
