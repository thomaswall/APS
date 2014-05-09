import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;


public class billiard-bounces {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String newline;
		StringTokenizer st;
		int verticals;
		int horizontals;
		int x,y,v,a,s;
		int distance;
		double x_dist,y_dist;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			if((x+y+v+a+s)!=0)
			{
				distance = v*s/2;
				y_dist = distance*Math.sin(Math.PI*(a)/180)-y/2;
				x_dist = distance*Math.cos(Math.PI*(a)/180)-x/2;
				horizontals = (int)Math.ceil(x_dist/(double)x);
				verticals = (int)Math.ceil(y_dist/(double)y);
				sb.append(horizontals).append(" ").append(verticals).append("\n");

			}
		}
		System.out.print(sb);

	}
}
