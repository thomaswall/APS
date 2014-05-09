import java.io.*;
import java.util.*;
import java.math.*;

public class exclusively-edible {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int m,n,r,c;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if((r ^ c ^ (m-r-1) ^ (n-c-1))==0)
			{
				sb.append("Hansel").append("\n");
			}
			else
			{
				sb.append("Gretel").append("\n");
			}

		}
		System.out.print(sb);
	}

}
