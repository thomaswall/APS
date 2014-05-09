import java.io.*;
import java.util.*;
import java.math.*;

public class tennis-contest {
	public static double comb(double n, double k)
	{
		double temp = 1;
		for(int i=1;i<=k;i++)
		{
			temp*=(n-i+1);
			temp/=i;
		}
		return temp;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		double games;
		double prob;
		double answer;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			answer=0;
			st = new StringTokenizer(stdin.readLine());
			games = Double.parseDouble(st.nextToken());
			st = new StringTokenizer(stdin.readLine());
			prob = Double.parseDouble(st.nextToken());

			for(double j=games;j<=games*2-1;j++)
			{
				answer+=(comb(games*2-1,j)*Math.pow(prob,j)*Math.pow(1-prob,games*2-1-j));
			}
			answer = Math.rint(answer*100)/100;
			String end = String.valueOf(answer);
			if(end.length()==3){end=end+"0";}
			sb.append(end).append("\n");
		}
		System.out.print(sb);
	}

}
