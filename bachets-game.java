import java.io.*;
import java.util.*;
import java.math.*;

public class bachets-game {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String newline;
		StringBuilder sb = new StringBuilder();
		int total;
		int[] restraints;
		int[] dp;
		int stone;
		int temp;
		
		while((newline=stdin.readLine())!=null)
		{
			if (newline.trim().length() == 0) continue;
			st = new StringTokenizer(newline);
			total = Integer.parseInt(st.nextToken());
			restraints = new int[Integer.parseInt(st.nextToken())];
			dp = new int[total+1];
			for(int i=0;i<restraints.length;i++)
			{
				stone = Integer.parseInt(st.nextToken());
				restraints[i]= stone;
			}
			temp =0;
			for(int i=0;i<=total;i++)
			{
				if(dp[i]==0)
				{
					for(int j=0;j<restraints.length;j++)
					{
						temp = restraints[j]+i;
						if (temp > total) continue;
						dp[temp]=1;
		
					}
				}
			}
			if(dp[total]==1)
			{
				sb.append("Stan wins").append("\n");
			}
			else
			{
				sb.append("Ollie wins").append("\n");
			}
				
		}
		System.out.print(sb);
	}

}
