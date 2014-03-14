import java.io.*;
import java.util.*;
import java.math.*;

public class task-order {

	public static void dfs(ArrayList<ArrayList<Integer>> adj,int[] state,int node,List<Integer> prod)
	{
		if(state[node]==0)
		{
			state[node] = 1;
			for(int j=0;j<adj.get(node).size();j++)
			{
				if(state[adj.get(node).get(j)]==0)
				{
					dfs(adj,state,adj.get(node).get(j),prod);
				}
			}	
			prod.add(node+1);
		}
		return;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tasks;
		int order;
		int first;
		int second;
		int[] state;
		ArrayList<ArrayList<Integer>> adj;
		ArrayList<Integer> prod;
		int count=0;

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			if((tasks = Integer.parseInt(st.nextToken()))!=0)
			{
				if(count!=0)
				{
					sb.append("\n");
				}
				count++;
				if((order = Integer.parseInt(st.nextToken()))!=0)
				{
					state = new int[tasks];
					adj = new ArrayList<ArrayList<Integer>>();
					prod = new ArrayList<Integer>();
					for (int i=0;i<tasks;i++)
					{
						adj.add(new ArrayList<Integer>());
					}
					for(int i=0;i<order;i++)
					{
						st = new StringTokenizer(stdin.readLine());
						first = Integer.parseInt(st.nextToken());
						second = Integer.parseInt(st.nextToken());
						adj.get(first-1).add(second-1);
					}

					for(int i=0;i<tasks;i++)
					{
						state[i]=0;
					}

					for(int i=0;i<tasks;i++)
					{
						dfs(adj,state,i,prod);
					}

					Collections.reverse(prod);

					for(int i=0;i<tasks;i++)
					{
						if(i==tasks-1)
						{
							sb.append(prod.get(i));
						}
						else
						{
							sb.append(prod.get(i)).append(" ");
						}
					}
				}
				else
				{
					prod = new ArrayList<Integer>();
					for(int i=0;i<tasks;i++)
					{
						prod.add(i+1);
					}
					for(int i=0;i<tasks;i++)
					{
						if(i==tasks-1)
						{
							sb.append(prod.get(i));
						}
						else
						{
							sb.append(prod.get(i)).append(" ");
						}
					}
				}
			}
		}
		System.out.println(sb);
	}

}
