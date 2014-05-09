import java.io.*;
import java.util.*;
import java.math.*;

public class extend-to-palindrome {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int rows;
		int columns;
		String newline;
		int answer;

		while((newline=stdin.readLine())!=null)
		{
			if(newline.charAt(0)!='.')
			{
				outerloop:
				for(int i=1;i<=newline.length();i++)
				{
					if((newline.length()%i)==0)
					{
						innerloop:
						for(int j=0;j<newline.length();j+=i)
						{
							for(int k=0;k<i;k++)
							{
								if(newline.charAt(k)!=newline.charAt(j+k))
								{
									break innerloop;
								}
								else if(j==(newline.length()-i) && k==(i-1))
								{
									sb.append(newline.length()/i).append("\n");
									break outerloop;
								}
							}
						}
					}
				}
			}
		}
		System.out.print(sb);

		
			
	}
}
