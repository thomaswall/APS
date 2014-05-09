import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class base-i-1 {


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringTokenizer st;
		String newline;
		int a,b,tempa,tempb;
		
		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			sb.append("Case #").append(i+1).append(": ");
			st = new StringTokenizer(stdin.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a==0 && b==0)
			{
				sb2.append(0);
			}
			while(a!=0 || b!=0)
			{
				if(Math.abs((a+b)%2)==1)
				{
					sb2.append(1);
					a--;
				}
				else
				{
					sb2.append(0);
				}

				tempa=-(a-b)/2;
				tempb=-(a+b)/2;
				a=tempa;
				b=tempb;
			}
			sb.append(sb2.reverse().toString()).append("\n");
			sb2.setLength(0);
		}

		System.out.print(sb);
		}

}
