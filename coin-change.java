import java.io.*;
import java.util.*;
import java.math.*;

public class coin-change {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int goal;
		int[] coins = {1,8,27,64,125,216,343,512,729,1000,1331,1728,2197,2744,3375,4096,4913,5832,6859,8000,9261};
		long[][] dp = new long[10000][coins.length];

		for(int i=0;i<10000;i++)
		{
			dp[i][0] = 1;
		}

		for(int i=1;i<coins.length;i++)
		{
			for(int j=0;j<10000;j++)
				{
					if(j-coins[i]>=0)
					{
						dp[j][i]= dp[j][i-1] + dp[j-coins[i]][i];
					}
					else
					{
						dp[j][i]=dp[j][i-1];
					}
				}
		}

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			goal = Integer.parseInt(st.nextToken());
			System.out.println(dp[goal][coins.length-1]);
		}			
}
