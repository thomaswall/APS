import java.io.*;
import java.util.*;
import java.math.*;

public class diving-for-gold {

	public static int value(int id,int time, int max, int breath, int[] distances,int[] gold,int[][] dp)
	{
		if(time==breath)
		{
		}
		else if(id==max)
		{
		}
		else if(time+distances[id]>breath)
		{
			return value(id+1,time,max,breath,distances,gold,dp);
		}
		else if(time+distances[id]<=breath)
		{	
			int use=gold[id]+value(id+1,time+distances[id],max,breath,distances,gold,dp);
			int next=value(id+1,time,max,breath,distances,gold,dp);
			if(next>use)
			{
				dp[time][id]=next;
				return next;
			}
			else
			{
				dp[time][id]=use;
				return use;
			}
		}
		return 0;
	}

	public static int buildOut(int id,int time, int max, int breath,int[] distances,int[] gold,int[][] dp,StringBuilder sb,int w)
	{
		if(id==max)
		{
			return 0;
		}
		if(time+distances[id]<=breath && value(id+1,time+distances[id],max,breath,distances,gold,dp)+gold[id]==value(id,time,max,breath,distances,gold,dp))
		{
			sb.append(distances[id]/3/w).append(" ").append(gold[id]).append("\n");
			return buildOut(id+1,time+distances[id],max,breath,distances,gold,dp,sb,w)+1;
		}
		else
		{
			return buildOut(id+1,time,max,breath,distances,gold,dp,sb,w);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb;
		int[] distances;
		int[] gold;
		boolean[] answers;
		int cases;
		int w;
		int breath;
		int sum;
		int used;
		int[][] dp;
		int count=0;
		
		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			if(st.hasMoreTokens())
			{
				breath = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens())
				{
					if(count!=0)
					{
						System.out.print("\n");
					}
					count++;
					w = Integer.parseInt(st.nextToken());
					st = new StringTokenizer(stdin.readLine());
					cases = Integer.parseInt(st.nextToken());
					distances = new int[cases];
					gold = new int[cases];
					dp = new int[breath][cases];
					sb = new StringBuilder();
					for(int i=0;i<cases;i++)
					{
						newline = stdin.readLine();
						st = new StringTokenizer(newline);
						distances[i] = Integer.parseInt(st.nextToken())*3*w;
						gold[i] = Integer.parseInt(st.nextToken());
						for(int j=0;j<breath;j++)
						{
							dp[j][i] = -1;
						}
					}

					System.out.println(value(0,0,cases,breath,distances,gold,dp));
					System.out.println(buildOut(0,0,cases,breath,distances,gold,dp,sb,w));
					System.out.print(sb);
				}
			}

		}
}
}
