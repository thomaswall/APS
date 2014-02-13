
import java.io.*;
import java.util.*;
import java.math.*;

public class max-subset-product {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		Integer index;
		BigInteger max;
		BigInteger multiplier;

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);

			while(st.hasMoreTokens())
			{
				index=Integer.parseInt(st.nextToken());
				
				if(index == -999999)
				{
					max = BigInteger.valueOf(-999999);

					for(int i=0;i<numbers.size();i++)
					{
						multiplier = BigInteger.valueOf(1);

						for(int j=i;j<numbers.size();j++)
						{
							multiplier = multiplier.multiply(BigInteger.valueOf(numbers.get(j)));
							if(multiplier.compareTo(max)==1)
							{
								max = multiplier;
							}
						}

					}

					if(max.equals(BigInteger.valueOf(-999999)))
					{
						sb.append(0).append("\n");
					}
					else
					{
						sb.append(max).append("\n");
					}
					numbers.clear();
				}
				else
				{
					numbers.add(index);
				}

			}
			
		}
		System.out.print(sb);
	}
}
