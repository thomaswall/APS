import java.io.*;
import java.util.*;
import java.math.*;

public class email-chain {
	static final int UNIT = 0;
	static final int PROCESSING = 1;
	static final int FINISHED = 2;
	static int[] state;
	static int[] total;
	static int[] adj;
	static int[] cycle;

	public static int cyclecounter(int[] adj,int node,int first,int counter)
	{
		while(adj[node]!=first)
		{
			counter++;
			cycle[node]=1;
			node = adj[node];
			cycle[node]=1;
		}
		return counter+1;
	}

	public static void cyclefinder(int[] adj,int node,int counter)
	{
		for(int i=0;i<counter;i++)
		{
			state[node]=FINISHED;
			total[node]=counter;
			node = adj[node];
		}
	}



	public static int dfs(int[] adj,int node)
	{
		int done = 1;
		if(adj[node]==-1)
		{
			total[node]=1;
			state[node]=FINISHED;
		}
		else
		{
			if(state[node]==FINISHED)
			{
				done = total[node];
			}
			else if(state[node]==UNIT)
			{
				state[node] = PROCESSING;
				int recurse = dfs(adj,adj[node]);
				if(cycle[adj[node]]==1 && cycle[node]==1)
				{
					total[node]=recurse;
				}
				else
				{
					total[node] = recurse+1;
				}
				done = total[node];
				state[node] = FINISHED;
			}
			else
			{
				int c = cyclecounter(adj,node,node,0);
				cyclefinder(adj,node,c);
				done = total[node];
			}
		}
		return done;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int first;
		int second;
		int cases;
		int proc;
		int max;
		int min;
		int counter=1;

		newline = stdin.readLine();
		st = new StringTokenizer(newline);
		cases = Integer.parseInt(st.nextToken());

		for(int i=0;i<cases;i++)
		{
			max = 0;
			min =50001;
			st = new StringTokenizer(stdin.readLine());
			proc = Integer.parseInt(st.nextToken());
			adj = new int[proc];
			total = new int[proc];
			state = new int[proc];
			cycle = new int[proc];
			for(int j=0;j<proc;j++)
			{
				adj[j]=-1;
				state[j]=UNIT;
			}

			for(int j=0;j<proc;j++)
			{
				st = new StringTokenizer(stdin.readLine());
				first = Integer.parseInt(st.nextToken());
				second = Integer.parseInt(st.nextToken());
				adj[first-1]=second-1;
			}

			for(int j=0;j<proc;j++)
			{
				int complete = dfs(adj,j);
				System.out.println(j+1 + ": " + complete);
				if(complete>max)
				{
					max=complete;
					min=j;
				}
			}
			sb.append("Case ").append(counter).append(": ").append(min+1).append("\n");
			counter++;
		}
		System.out.print(sb);
	}

}
