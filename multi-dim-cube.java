import java.io.*;
import java.util.*;
import java.math.*;



public class multi-dim-cube {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<Integer,Integer> cube= new HashMap<Integer,Integer>();
		int[] sums;
		int sum2;
		int max=0;
		int dimensions=0;

		while((newline=stdin.readLine())!=null)
		{
			sums = new int[16384];
			for(int i=0;i<sums.length;i++)
			{
				sums[i]=0;
			}

			st = new StringTokenizer(newline);
			dimensions = Integer.parseInt(st.nextToken());

			for(int j=0;j<Math.pow(2,dimensions);j++)
			{
				st = new StringTokenizer(stdin.readLine());
				cube.put(j,Integer.parseInt(st.nextToken()));
			}

			max = 0;

			for(int j=0;j<Math.pow(2,dimensions);j++)
			{
				for(int k=0;k<dimensions;k++)
					{
						sums[j]+=cube.get(j^(1<<k));
					}
			}

			for(int j=0;j<Math.pow(2,dimensions);j++)
			{
				for(int k=0;k<dimensions;k++)
					{
						sum2=sums[j]+sums[j^(1<<k)];
						if(sum2>max)
						{
							max=sum2;
						}
					}
			}

			sb.append(max).append("\n");
			cube.clear();

		}



		System.out.print(sb);
	}
}
