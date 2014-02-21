import java.io.*;
import java.util.*;
import java.math.*;

public class first-occurrence-marble {

	static int search(int temp,int highest,int lowest,int[] marbles,int middle){
		middle = (highest+lowest)/2;
		if((highest-lowest)>=0)
		{
			if(marbles[middle]>temp)
			{
				return search(temp,middle-1,lowest,marbles,middle);
			}
			else if(marbles[middle]<temp)
			{
				return search(temp,highest,middle+1,marbles,middle);
			}
			else if(marbles[middle]==temp)
			{
				while(middle>0 && marbles[middle-1]==temp)
				{
					middle=middle-1;
				}
				return (middle+1);
			}
		}
		return -1;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int total_marbles;
		int queries;
		int[] marbles;
		int temp;
		int count=1;

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			total_marbles = Integer.parseInt(st.nextToken());
			queries = Integer.parseInt(st.nextToken());


			if(total_marbles!=0 && queries!=0)
			{
				marbles = new int[total_marbles];
				sb.append("CASE# ").append(count).append(":\n");
				for(int i=0;i<total_marbles;i++)
				{
					st = new StringTokenizer(stdin.readLine());
					marbles[i] = Integer.parseInt(st.nextToken());

				}

				Arrays.sort(marbles);

				for(int j=0;j<queries;j++)
				{
					st = new StringTokenizer(stdin.readLine());
					temp=Integer.parseInt(st.nextToken());
					int middle = -1;

					int highest = marbles.length-1;
					int lowest = 0;

					int query = search(temp,highest,lowest,marbles,middle);


					if(query== -1)
					{
						sb.append(temp).append(" not found\n");
					}
					else
					{
						sb.append(temp).append(" found at ").append(query).append("\n");
					}

				}

				count++;
			}
			else
			{
				break;
			}
		}
		System.out.print(sb);
}
}
