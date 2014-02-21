import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> distances;

		st = new StringTokenizer(stdin.readLine());
		int tests = Integer.parseInt(st.nextToken());

		for(int i=0;i<tests;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			int rocks = Integer.parseInt(st.nextToken());
			int bank = Integer.parseInt(st.nextToken());

			distances = new ArrayList<Integer>();

			distances.add(0);

			st = new StringTokenizer(stdin.readLine());

			for(int j=0;j<rocks;j++)
			{
				String[] rock = st.nextToken().split("-");
				if(rock[0].equals("S"))
				{
					distances.add(Integer.parseInt(rock[1]));
				}
				else
				{
					distances.add(Integer.parseInt(rock[1]));
					distances.add(Integer.parseInt(rock[1]));
				}
			}

			distances.add(bank);
			int max=0;

			for(int j=2;j<distances.size();j++)
			{
				if((distances.get(j)-distances.get(j-2))>max)
				{
					max = (distances.get(j)-distances.get(j-2));
				}
			}
			sb.append("Case ").append(i+1).append(": ").append(max).append("\n");
		}


		
		System.out.print(sb);
}
}
