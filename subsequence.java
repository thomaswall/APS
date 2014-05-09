import java.io.*;
import java.util.*;
import java.math.*;

public class subsequence {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		int s,n;
		int min;
		Deque<Integer> deque;
		int next;
		int sum;
		int temp;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			n = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			sum=0;
			deque = new LinkedList<Integer>();
			min = Integer.MAX_VALUE;
			temp = Integer.MAX_VALUE;

			st = new StringTokenizer(stdin.readLine());

			for(int i=0;i<n;i++)
			{
				next = Integer.parseInt(st.nextToken());
				deque.addLast(next);
				sum+=next;
				while(sum>=s)
				{
					temp = deque.size();
					sum-=deque.pollFirst();
				}
				if(temp<min)
				{
					min = temp;
				}
			}

			if(min==Integer.MAX_VALUE)
			{
				sb.append(0).append("\n");
			}
			else
			{
				sb.append(min).append("\n");
			}
		}
		System.out.print(sb);

		

	}
}
