import java.io.*;
import java.util.*;
import java.math.*;

public class eventual-periodic-sequence {


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		long mod;
		long x;
		Stack equation;
		String temp;
		ArrayList<String> list;
		int[] type;
		long first;
		long count;
		HashMap<Long,Long> dp;
		long done;


		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			equation = new Stack();
			count = 0;
			if((mod=Long.parseLong(st.nextToken()))!=0)
			{
				x = Long.parseLong(st.nextToken())%mod;
				list = new ArrayList<String>();
				dp = new HashMap<Long,Long>();
				while(!((temp=st.nextToken()).equals("N")))
				{
					list.add(temp);
				}

				type = new int[list.size()];

				for(int i=0;i<type.length;i++)
				{
					temp = list.get(i);
					if(temp.equals("*"))
					{
						type[i]=1;
					}
					else if(temp.equals("+"))
					{
						type[i]=2;
					}
					else if(temp.equals("x"))
					{
						type[i]=3;
					}
					else
					{
						type[i]=4;
					}
				}
				do{
					dp.put(x,count);
					for(int i=0;i<type.length;i++)
					{
						if(type[i]==4)
						{
							equation.push(Long.parseLong(list.get(i))%mod);
						}
						else if(type[i]==3)
						{
							equation.push(x%mod);
						}
						else if(type[i]==2)
						{
							equation.push(((Long)equation.pop()+(Long)equation.pop())%mod);
						}
						else
						{
							equation.push(((Long)equation.pop()*(Long)equation.pop())%mod);
						}
					}
					count++;
					x=(Long)equation.pop()%mod;
				}while(!dp.containsKey(x));

				sb.append(count-dp.get(x)).append("\n");

			}
		}
		System.out.print(sb);
	}

}
