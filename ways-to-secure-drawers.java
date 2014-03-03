import java.io.*;
import java.util.*;
import java.math.*;

public class ways-to-secure-drawers {

	public static long solve(int l,int n,int s,int drawers,int secured,long[][][] dp)
	{
		long i=0;

		if(drawers<n || secured<s)
		{
			return 0;
		}
		if(n==drawers && s==secured)
		{
			return 1;
		}

		if(dp[n][s][l]>=0)
		{
			return dp[n][s][l];
		}

		else
		{
			if(l==0)
			{
				i+=solve(0,n+1,s,drawers,secured,dp)+solve(1,n+1,s,drawers,secured,dp);
			}
			else
			{
				i+=solve(0,n+1,s,drawers,secured,dp)+solve(1,n+1,s+1,drawers,secured,dp);
			}

			dp[n][s][l]=i;
		}
		return i;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int drawers;
		int secured;
		long[][][] dp = new long[66][66][2];

		while((newline = stdin.readLine())!=null)
		{
			for(int i=0;i<65;i++)
			{	
				for(int j=0;j<66;j++)
				{
					dp[i][j][0]=-1;
					dp[i][j][1]=-1;
				}
			}
			st = new StringTokenizer(newline);
			drawers = Integer.parseInt(st.nextToken());
			secured = Integer.parseInt(st.nextToken());
			if(drawers>=0 && secured>=0)
			{
				sb.append(solve(1,0,0,drawers,secured,dp)).append("\n");
			}
		}
		System.out.print(sb);
}
}
