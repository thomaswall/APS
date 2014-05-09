import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class tour {
public static int points;
public static double[][] d;
public static double[][] memo2d;

public static double dp2(int p1,int p2)
{
	int v = 1+Math.max(p1,p2);
	if(v==points-1)
	{
		return  d[p1][v]+d[v][p2];
	}
	if(memo2d[p1][p2]>-0.5)
	{
		return memo2d[p1][p2];
	}
	return memo2d[p1][p2]=Math.min(d[p1][v]+dp2(v,p2),d[v][p2]+dp2(p1,v));
}


	public static void main(String[] args) throws IOException{
		Scanner stdin = new Scanner(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String newline;
		int[][] point; 
		double result;
		DecimalFormat df = new DecimalFormat("#0.00");



		while(stdin.hasNextInt())
		{
			points = stdin.nextInt();
			d = new double[points][points];
			memo2d = new double[points][points];
			point = new int[points][2];

			for(int i=0;i<points;i++)
			{
				point[i][0]=stdin.nextInt();
				point[i][1]=stdin.nextInt();
			}

			for(int i=0;i<points;i++)
			{
				for(int j=0;j<points;j++)
				{
					memo2d[i][j]=-1;
				}
			}

			for(int i=0;i<points;i++)
			{
				for(int j=0;j<points;j++)
				{
					d[i][j]=Math.hypot(point[i][0]-point[j][0],point[i][1]-point[j][1]);
				}
			}

			sb.append(df.format(Math.round(dp2(0,0)*100.0)/100.0)).append("\n");
		}
		System.out.print(sb);

		

	}
}
