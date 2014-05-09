import java.io.*;
import java.util.*;
import java.math.*;

public class GCD {

	static int[][] dp;

	public static int gcd(int i,int j)
	{
		int first = i;
		int second = j;
		if(dp[first][second]!=-1)
		{
			return dp[first][second];
		}
		else
		{
			if(i==0 || j==0)
			{
				dp[first][second]=0;
			}
			else
			{
				while(i!=0 && j!=0)
				{
					if(i>j)
					{
						i=i%j;
					}
					else
					{
						j=j%i;
					}
				}
				dp[first][second]=Math.max(i,j);
			}
			return dp[first][second];
		}
	}


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n;
		int g;
		dp = new int[501][501];

		for(int i=0;i<501;i++)
		{
			for(int j=0;j<501;j++)
			{
				dp[i][j]=-1;
			}
		}


		while((newline = stdin.readLine())!=null)
		{
			g=0;
			st = new StringTokenizer(newline);
			n = Integer.parseInt(st.nextToken());
			if(n!=0)
			{
				for(int i=0;i<n;i++)
				{
					for(int j=i+1;j<=n;j++)
					{
						g+=gcd(i,j);
					}
				}
				sb.append(g).append("\n");
			}
		}
		System.out.print(sb);
	}

}
