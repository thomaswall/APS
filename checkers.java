import java.io.*;
import java.util.*;
import java.math.*;

public class checkers {

	public static int[][] memo;

	public static int recurs(int col,int row,int grid,char dp[][])
	{
		if(memo[row][col]!=-1)
		{
		}
		else if(dp[row][col]=='B')
		{
			return 0;
		}
		else if(col<2 || col>grid+1 || row<2)
		{
			memo[row][col]=0;
		}
		else if(row==2)
		{
			memo[row][col]=1;
		}
		else
		{
			if(dp[row-1][col-1]=='B' && dp[row-1][col+1]=='B')
			{
				memo[row][col] = (recurs(col-2,row-2,grid,dp) + recurs(col+2,row-2,grid,dp))%1000007;
			}
			else if(dp[row-1][col-1]=='B' && dp[row-1][col+1]!='B')
			{
				memo[row][col] = (recurs(col-2,row-2,grid,dp) + recurs(col+1,row-1,grid,dp))%1000007;
			}
			else if(dp[row-1][col-1]!='B' && dp[row-1][col+1]=='B')
			{
				memo[row][col] = (recurs(col-1,row-1,grid,dp) + recurs(col+2,row-2,grid,dp))%1000007;
			}
			else
			{
				memo[row][col] = (recurs(col-1,row-1,grid,dp) + recurs(col+1,row-1,grid,dp))%1000007;
			}
		}

		return memo[row][col];
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int grid;
		char dp[][];
		char current;
		int white_col=0;
		int white_row=0;


		newline = stdin.readLine();
		st = new StringTokenizer(newline);
		int cases = Integer.parseInt(st.nextToken());

		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			grid = Integer.parseInt(st.nextToken());
			dp = new char[grid+4][grid+4];
			memo = new int[grid+4][grid+4];

			for(int j=2;j<grid+2;j++)
			{
				newline = stdin.readLine();
				for(int k=2;k<grid+2;k++)
				{
					current = newline.charAt(k-2);
					dp[j][k]=current;
					if(current=='W')
					{
						white_col = k;
						white_row = j; 
					}
				}
			}

			for(int j=0;j<grid+4;j++)
			{
				for(int k=0;k<grid+4;k++)
				{
					memo[j][k]=-1;
				}
			}
			recurs(white_col,white_row,grid,dp);

			sb.append("Case ").append(i+1).append(": ").append(memo[white_row][white_col]).append("\n");

		}

		System.out.print(sb);

	
	}

}
