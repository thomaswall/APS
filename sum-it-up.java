import java.io.*;
import java.util.*;
import java.math.*;

public class sum-it-up {

	static void summing(ArrayList<Integer> all,int goal,ArrayList<ArrayList<Integer>> sums,StringBuilder sb,ArrayList<Integer> sector)
	{
		int sum = 0;
		for(int i=0;i<sector.size();i++)
		{
			sum+=sector.get(i);
		}

		boolean same=true;

		if(sum==goal)
		{

			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = sector;
			Collections.sort(sector);

			for(int i=0;i<sums.size();i++)
			{
				if(sums.get(i).equals(sector))
				{
					same = false;
				}
			}
			sums.add(sector);

			if(same)
			{
				sb.append(temp.get(temp.size()-1));
				for(int i=temp.size()-2;i>=0;i--)
				{
					sb.append("+").append(temp.get(i));
				}
				sb.append("\n");
			}

			return;
		}

		if(sum>goal)
		{
			return;
		}

		for(int i=0;i<all.size();i++)
		{
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> sector2 = new ArrayList<Integer>(sector);

			for(int j=i+1;j<all.size();j++)
			{
				left.add(all.get(j));
			}
			sector2.add(all.get(i));
			summing(left,goal,sums,sb,sector2);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			int goal = Integer.parseInt(st.nextToken());
			int list = Integer.parseInt(st.nextToken());

			if(goal!=0 && list!=0)
			{
				ArrayList<ArrayList<Integer>> sums = new ArrayList<ArrayList<Integer>>();
				ArrayList<Integer> all = new ArrayList<Integer>();
				sb.append("Sums of ").append(goal).append(":\n");

				for(int i=0;i<list;i++)
				{
					all.add(Integer.parseInt(st.nextToken()));
				}
				summing(all,goal,sums,sb,new ArrayList<Integer>());

				if(sums.size()==0)
				{
					sb.append("NONE\n");
				}
			}
			else
			{
				break;
			}
		}


		
		System.out.print(sb);
}
}
