import java.io.*;
import java.util.*;
import java.math.*;

public class max-sum-in-cube {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		int a;
		int b;
		int c;
		long[][][] garbage;
		long subRect;
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			st = new StringTokenizer(stdin.readLine());
			a=Integer.parseInt(st.nextToken());
			b=Integer.parseInt(st.nextToken());
			c=Integer.parseInt(st.nextToken());
			garbage = new long[a][b][c];

			st = new StringTokenizer(stdin.readLine());

			for(int j=0;j<a;j++)
			{
				for(int k=0;k<b;k++)
				{
					for(int l=0;l<c;l++)
					{
						if(st.hasMoreTokens())
						{
							garbage[j][k][l]=Long.parseLong(st.nextToken());
						}
						else
						{
							st = new StringTokenizer(stdin.readLine());
							garbage[j][k][l]=Long.parseLong(st.nextToken());
						}
						if(k>0)
						{
							garbage[j][k][l]+=garbage[j][k-1][l];
						}
						if(l>0)
						{
							garbage[j][k][l]+=garbage[j][k][l-1];
						}
						if(k>0 && l>0)
						{
							garbage[j][k][l]-=garbage[j][k-1][l-1];
						}
					}
				}
			}

			long max=Long.MIN_VALUE;
			for(int j=0;j<b;j++)
			{
				for(int k=0;k<c;k++)
				{
					for(int l=j;l<b;l++)
					{
						for(int m=k;m<c;m++)
						{
							long max2=0;
							for(int n=0;n<a;n++)
							{
								subRect = garbage[n][l][m];
								if(k>0)
								{
									subRect-=garbage[n][l][k-1];
								}
								if(j>0)
								{
									subRect-=garbage[n][j-1][m];
								}
								if(k>0 && j>0)
								{
									subRect+=garbage[n][j-1][k-1];
								}
								max2=Math.max(subRect,max2+subRect);
								max=Math.max(max,max2);
							}
						}
					}
				}
			}
			sb.append(max).append("\n");
			if(i<cases-1)
			{
				sb.append("\n");
			}
		}
		System.out.print(sb);

}
}
