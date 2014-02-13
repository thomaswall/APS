import java.io.*;
import java.util.*;
import java.math.*;

class sizes implements Comparable<sizes>
{
	int size;
	String class1;

	public sizes(int size,String class1)
	{
		this.size = size;
		this.class1 = class1;
	}

	@Override
	public int compareTo(sizes o)
	{
		return size > o.size ? -1 : size < o.size ? 1 : (class1.compareTo(o.class1) < 0 ? -1 : class1.compareTo(o.class1) > 0 ? 1 : 0);
	}
}

public class class-signup {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		HashMap<String,Set<String>> classes = new HashMap<String,Set<String>>();
		HashMap<String,String> firstclass = new HashMap<String,String>();
		String name;
		String classer="";
		List<sizes> all;
		int temp;


		while((name = stdin.readLine())!=null)
		{

			if(!name.equals("0"))
			{
				if(!name.equals("1"))
				{
					if(Character.isUpperCase(name.charAt(0)))
					{
						Set<String> kids = new HashSet<String>();
						classer = name;
	            		classes.put(name,kids);
	            	}
	            	else
	            	{
	            		if(firstclass.get(name)==null)
	            		{
	            			classes.get(classer).add(name);
	            			firstclass.put(name,classer);
	            		}
	            		else if(firstclass.get(name)==classer)
	            		{
	            		}
	            		else
	            		{
	            			classes.get(firstclass.get(name)).remove(name);
	            		}
	            		
	            	}
				}
				else
				{
					all = new ArrayList<sizes>();

					for (Map.Entry<String, Set<String>> entry : classes.entrySet())
					{
						all.add(new sizes(entry.getValue().size(),entry.getKey()));
					}

					Collections.sort(all);

					for(int i=0;i<all.size();i++)
					{
						sb.append(all.get(i).class1).append(" ").append(all.get(i).size).append("\n");
					}

					classes.clear();
					all.clear();
					firstclass.clear();
				}
			}
			
		}

		System.out.print(sb);
	}
}
