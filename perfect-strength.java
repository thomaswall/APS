import java.io.*;
import java.util.*;
import java.math.*;

public class perfect-strength {

	static boolean jumper(int strength,int rungs,int[] rung){
		for(int i=1;i<rung.length;i++)
		{
			int tester = (rung[i]-rung[i-1]);
			if(tester > strength)
			{
				return false;
			}
			else if(tester==strength)
			{
				strength=strength-1;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[] rung;
		int highest;
		int lowest;
		int middle;

		st = new StringTokenizer(stdin.readLine());
		int tests = Integer.parseInt(st.nextToken());

		for(int i=0;i<tests;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			int rungs = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(stdin.readLine());
			rung = new int[rungs+1];

			for(int j=1;j<rungs+1;j++)
			{
				rung[j]=Integer.parseInt(st.nextToken());
			}

			highest = 10000001;
			lowest = 0;
			middle = 0;
			middle = highest/2;


			while((highest-lowest) >= 1)
			{
				if(jumper(middle,rungs,rung))
				{
					highest = middle;
				}
				else
				{
					lowest = middle+1;
				}

				middle = (highest+lowest)/2;
			}


			sb.append("Case ").append(i+1).append(": ").append(middle).append("\n");

		}

		System.out.print(sb);
}
}
