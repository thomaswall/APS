import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class stupid-sequence {


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringTokenizer st;
		String newline;
		long[] f= new long[1500];
		long[] ans;
		boolean smart = false;
		
		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			if(i!=0)
			{
				stdin.readLine();
			}
			ans = new long[7];
			for(int j=0;j<1500;j++)
			{
				st = new StringTokenizer(stdin.readLine());
				f[j]=Long.parseLong(st.nextToken());
			}
			ans[0]=f[1000]%1001;
			long temp = f[1000];
			for(int j=1;j<7;j++)
			{
				temp = temp-ans[j-1];
				temp = temp/1001;
				ans[j]=temp%1001;
			}
			for(int j=1;j<1501;j++)
			{
				temp=ans[0]+ans[1]*j+ans[2]*j*j+ans[3]*j*j*j+ans[4]*j*j*j*j+ans[5]*j*j*j*j*j+ans[6]*j*j*j*j*j*j;
				if(temp!=f[j-1])
				{
					smart=true;
					break;
				}
			}

			if(smart)
			{
				sb.append("This is a smart sequence!\n");
			}
			else
			{
				sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]).append(" ").append(ans[3]).append(" ").append(ans[4]).append(" ").append(ans[5]).append(" ").append(ans[6]).append("\n");
			}
			smart = false;
			
		}

		System.out.print(sb);
		}

}
