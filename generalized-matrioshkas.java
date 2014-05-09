import java.io.*;
import java.util.*;
import java.math.*;

public class generalized-matrioshkas {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		Stack<Integer> stack;
		HashMap<Integer,ArrayList<Integer>> map;
		int temp=0;
		int sum=0;


		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			stack = new Stack<Integer>();
			map = new HashMap<Integer,ArrayList<Integer>>();
			stack.push(Integer.parseInt(st.nextToken()));
			while(st.hasMoreTokens())
			{
				temp = Integer.parseInt(st.nextToken());
				if(temp==-stack.peek())
				{
					stack.pop();
					sum=0;
					if(map.containsKey(-temp))
					{
						for(int i=0;i<map.get(-temp).size();i++)
						{
							sum+=map.get(-temp).get(i);
						}
					}
					if(sum>=temp)
					{
						break;
					}
					map.remove(-temp);

					if(stack.empty())
					{
						break;
					}
					else
					{
						if(map.containsKey(stack.peek()))
						{
						}
						else
						{
							map.put(stack.peek(),new ArrayList());
						}
						map.get(stack.peek()).add(temp);
					}
				}
				else
				{
					stack.push(temp);
				}
			}

			if(stack.empty() && sum!=temp)
			{
				sb.append(":-) Matrioshka!\n");
			}
			else
			{
				sb.append(":-( Try again.\n");
			}


		}
		System.out.print(sb);

		

	}
}
