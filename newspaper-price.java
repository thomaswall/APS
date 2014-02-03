import java.io.*;
import java.util.*;
import java.math.*;


public class newspaper-price {

	
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		int tests;
		long totalcharacters;
		long lines;
		StringTokenizer st;
		HashMap<Character,Integer> values = new HashMap<Character,Integer>();
		long total=0;
		String line;
		long key;
		int j;

		tests = Integer.parseInt(stdin.readLine());
		for(int i=0;i<tests;i++)
		{
			totalcharacters = Long.parseLong(stdin.readLine());
			j=0;

			while(j<totalcharacters)
			{
				st = new StringTokenizer(stdin.readLine());
				values.put((st.nextToken()).charAt(0),Integer.parseInt(st.nextToken()));
				j++;
			}

			j=0;

			lines = Long.parseLong(stdin.readLine());

			while(j<lines)
			{
				line = stdin.readLine();

				for(int l=0;l<line.length();l++)
				{
					if(values.get(line.charAt(l))!=null)
					{
						total+=values.get(line.charAt(l));
					}
				}
				j++;

			}
			values.clear();
			System.out.printf("%.2f$\n",(double)(total)/100);
			total = 0;
		}


		

	}

}
