import java.io.*;
import java.util.*;
import java.math.*;

public class guards {

	static int test1;
	static int test2;
	public static int dfs(ArrayList<ArrayList<Integer>> adj,int[] state,int node,int last)
	{
		int done=0;
		if(state[node]==0)
		{
			if(state[last]==1)
			{
				state[node]=2;
				test2++;
			}
			else
			{
				state[node]=1;
				test1++;
			}

			if(test1>test2)
			{
				done = test2;
			}
			else
			{
				done = test1;
			}

			for(int j=0;j<adj.get(node).size();j++)
			{
				if(adj.get(node).get(j)!=last)
				{
					done = dfs(adj,state,adj.get(node).get(j),node);
					if(done==-1)
					{
						return -1;
					}
				}
			}	
		}
		else
		{
			if(state[last]==state[node])
			{
				return -1;
			}
		}
		return done;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int junctions;
		int[] state;
		int cases;
		int junction1;
		int junction2;
		int streets;
		ArrayList<ArrayList<Integer>> adj;

		st = new StringTokenizer(stdin.readLine());
		cases = Integer.parseInt(st.nextToken());

		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			junctions = Integer.parseInt(st.nextToken());
			streets = Integer.parseInt(st.nextToken());
			adj = new ArrayList<ArrayList<Integer>>();

			state = new int[junctions];

			for (int j=0;j<junctions;j++)
			{
				adj.add(new ArrayList<Integer>());
			}

			for (int j=0;j<junctions;j++)
			{
				state[j] = 0;
			}

			for(int j=0;j<streets;j++)
			{
				st = new StringTokenizer(stdin.readLine());
				junction1 = Integer.parseInt(st.nextToken());
				junction2 = Integer.parseInt(st.nextToken());
				adj.get(junction1).add(junction2);
				adj.get(junction2).add(junction1);
			}

			int total = 0;
			int component=0;

			test1=0;
			test2=0;

			for(int j=0;j<junctions;j++)
			{
				if(state[j]==0)
				{
					component=dfs(adj,state,j,j);
					if(component==-1)
					{
						total=-1;
						break;
					}
					else
					{
						if(test1>test2)
						{
							if(test2==0)
							{
								total+=1;
							}
							else
							{
								total+=test2;
							}
						}
						else
						{
							if(test1==0)
							{
								total+=1;
							}
							else
							{
								total+=test1;
							}
						}
					}
					test1=0;
					test2=0;
				}
			}
			sb.append(total).append("\n");
		}

		System.out.print(sb);
	}

}
