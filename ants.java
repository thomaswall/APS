import java.io.*;
import java.util.*;
import java.math.*;

public class ants {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int cases;
		float stick;
		float ants;
		float ant;
		float min;
		float max;

		cases = sc.nextInt();

		for(int i=0;i<cases;i++)
		{
			stick = sc.nextInt();
			ants = sc.nextInt();
			max= 0;
			min= 0;

			for(int j=0;j<ants;j++)
			{
				ant=sc.nextInt();

				if(ant<=stick/2)
				{
					if(ant>min)
					{
						min = ant;
					}

					if((stick-ant)>max)
					{
						max=stick-ant;
					}
				}
				else
				{
					if((stick-ant)>min)
					{
						min = stick-ant; 
					}

					if(ant>max)
					{
						max = ant;
					}
				}
			}
			sb.append((int)min).append(" ").append((int)max).append("\n");

		}
		System.out.print(sb);
	}
}
