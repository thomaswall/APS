import java.io.*;
import java.util.*;

public class guess-that-data-structure.java {
	
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		long testcase;
		int operation=0;
		int operator=0;
		StringTokenizer st;
		boolean stack = true;
		boolean queue = true;
		boolean priority = true;
		StringBuilder sb = new StringBuilder();
		Stack<Integer> trystack = new Stack<Integer>();
		Queue<Integer> tryqueue = new LinkedList<Integer>();
		PriorityQueue<Integer> trypriority = new PriorityQueue<Integer>(100,Collections.reverseOrder());

		while((newline = stdin.readLine())!=null)
		{
			testcase = Integer.parseInt(newline);
			for(int i=0;i<testcase;i++)
			{
				st = new StringTokenizer(stdin.readLine());
				operation = Integer.parseInt(st.nextToken());
				operator = Integer.parseInt(st.nextToken());
			}

				if(operation==1)
				{
					trystack.push(operator);
					tryqueue.add(operator);
					trypriority.add(operator);
				}
				else
				{
					if(trystack.empty() || trystack.pop()!=operator)
					{
						stack = false;
					}
					if(tryqueue.peek()==null || tryqueue.poll()!=operator)
					{
						queue = false;
					}
					if(trypriority.peek()==null || trypriority.poll()!=operator)
					{
						priority = false;
					}

				}


			}
			if(!stack && !priority && !queue)
			{
				sb.append("impossible\n");
			}
			else if(stack && !priority && !queue)
			{
				sb.append("stack\n");
			}
			else if(queue && !priority && !stack)
			{
				sb.append("queue\n");
			}
			else if(priority && !stack && !queue)
			{
				sb.append("priority queue\n");
			}
			else
			{
				sb.append("not sure\n");
			}

			stack=true;
			queue=true;
			priority=true;

			tryqueue.clear();
			trystack.clear();
			trypriority.clear();

		}
		System.out.print(sb);
		
	}

}
