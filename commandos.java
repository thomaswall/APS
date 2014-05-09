import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int buildings;
		int roads;
		int[][] dp;
		int first;
		int second;
		int source;
		int sink;
		int distance;
		int count=0;


		newline = stdin.readLine();
		st = new StringTokenizer(newline);
		int cases = Integer.parseInt(st.nextToken());

		for(int i=0;i<cases;i++)
		{
			count++;
			distance = 0;
			st = new StringTokenizer(stdin.readLine());
			buildings = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(stdin.readLine());
			roads = Integer.parseInt(st.nextToken());

			dp = new int[buildings][buildings];

			for(int j=0;j<buildings;j++)
			{
				for(int k=0;k<buildings;k++)
				{
					if(k!=j)
					{
						dp[j][k]=100000000;
					}
				}
			}

			for(int j=0;j<roads;j++)
			{
				st = new StringTokenizer(stdin.readLine());
				first = Integer.parseInt(st.nextToken());
				second = Integer.parseInt(st.nextToken());
				dp[first][second] = 1;
				dp[second][first] = 1;
			}

			st = new StringTokenizer(stdin.readLine());
			source = Integer.parseInt(st.nextToken());
			sink = Integer.parseInt(st.nextToken());

			for(int j=0;j<buildings;j++)
			{
				for(int k=0;k<buildings;k++)
				{
					for(int l=0;l<buildings;l++)
					{
						dp[k][l] = Math.min(dp[k][l],dp[k][j]+dp[j][l]);
					}
				}
			}

			for(int j=0;j<buildings;j++)
			{
				distance = Math.max(distance,dp[source][j]+dp[j][sink]);
			}
			sb.append("Case ").append(count).append(": ").append(distance).append("\n");

		}

		System.out.print(sb);

	
	}

}
