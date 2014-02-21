import java.io.*;
import java.util.*;
import java.math.*;

public class voter-index {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(stdin.readLine());
		int tests = Integer.parseInt(st.nextToken());

		ArrayList<Integer> parties;
		boolean[] entries;
		int[] powers;

		for(int k=0;k<tests;k++)
		{
			int sum=0;
			st = new StringTokenizer(stdin.readLine());
			parties = new ArrayList<Integer>();

			int total = Integer.parseInt(st.nextToken());
			for(int i=0;i<total;i++)
			{
				parties.add(Integer.parseInt(st.nextToken()));
			}

			powers = new int[parties.size()];

			for(int i=0;i<parties.size();i++)
			{
				sum+=parties.get(i);
			}

			int majority = sum/2;

			for(int i=0;i<(1<<parties.size());i++)
			{
				ArrayList<Integer> subset = new ArrayList<Integer>();
				entries = new boolean[parties.size()];
				Arrays.fill(entries,Boolean.FALSE);
				sum=0;

				for(int j=0;j<parties.size();j++)
				{
					if(((i>>j)&1)==1)
					{
						subset.add(parties.get(j));
						entries[j]=true;
						sum+=parties.get(j);
					}
				}
				if(!(sum>majority))
				{
					for(int j=0;j<parties.size();j++)
					{
						if(entries[j]==false && (sum+parties.get(j))>majority)
						{
							powers[j]++;
						}
					}
				}
			}

			for(int i=0;i<powers.length;i++)
			{
				sb.append("party ").append(i+1).append(" has power index ").append(powers[i]).append("\n");
			}
			sb.append("\n");
		}

		System.out.print(sb);
}
}
