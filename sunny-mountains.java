import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class sunny-mountains {

	public static class Coordinate implements Comparable<Coordinate>
	{
		public double x=0;
		public double y=0;
		public Coordinate(double x,double y)
		{
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Coordinate o)
		{
			if(this.x<o.x)
			{
				return -1;
			}
			else
			{
				return 1;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		double x,y;
		Coordinate[] list;
		double runningtotal;
		double slope;
		double h;
		double ratio;
		double length;
		double lasty;
		DecimalFormat df = new DecimalFormat("#.##");

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			int coordinates = Integer.parseInt(st.nextToken());
			list = new Coordinate[coordinates];
			for(int j=0;j<coordinates;j++)
			{
				st = new StringTokenizer(stdin.readLine());
				x = Double.parseDouble(st.nextToken());
				y = Double.parseDouble(st.nextToken());
				list[j]= new Coordinate(x,y);
			}
			Arrays.sort(list);
			runningtotal=0;
			lasty=0;
			for(int j=coordinates-1;j>0;j--)
			{
				if(list[j-1].y>lasty)
				{
					h = Math.sqrt((list[j-1].y-list[j].y)*(list[j-1].y-list[j].y)+(list[j].x-list[j-1].x)*(list[j].x-list[j-1].x));
					ratio = (list[j-1].y-list[j].y)/h;
					length = (list[j-1].y-lasty)/ratio;
					runningtotal+=length;
					lasty = list[j-1].y;
				}
			}
			sb.append(df.format(runningtotal)).append("\n");

		}
		System.out.print(sb);

	}
}
