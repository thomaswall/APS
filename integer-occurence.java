import java.io.*;
import java.util.*;

public class integer-occurence.java {
	
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		int cases;
		int length;
		int place;
		int number;
		int numberinstring;
		HashMap<Integer,ArrayList<Integer>> values = new HashMap<Integer,ArrayList<Integer>>(100000);
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> places;
		ArrayList<Integer> answer;

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			length = Integer.parseInt(st.nextToken());
			cases = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(stdin.readLine());
			for(int i=1;i<=length;i++)
			{
				numberinstring = Integer.parseInt(st.nextToken());
				places = values.get(numberinstring);
				if (places==null)
				{
	    			places = new ArrayList<Integer>(2);;
	    			places.add(i);
	    			values.put(numberinstring,places);
				}
				else
				{
					places.add(i);
				}
			}
			for(int i=0;i<cases;i++)
			{
				st = new StringTokenizer(stdin.readLine());
				place = Integer.parseInt(st.nextToken());
				number = Integer.parseInt(st.nextToken());

				answer=values.get(number);

				if(answer.size()>=place)
				{
					sb.append(answer.get(place-1)).append('\n');
				}
				else
				{
					sb.append("0\n");
				}
			}

			values.clear();
			
		}
		System.out.print(sb);
	}
}
