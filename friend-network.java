import java.io.*;
import java.util.*;
import java.math.*;



public class friend-network {

	public static int findSet(int i,int[] p)
	{
		if(p[i]!=i)
		{
			p[i]=findSet(p[i],p);
		}
		return p[i];
	}

	public static boolean isSameSet(int i,int j,int[] p)
	{
		return findSet(i,p) == findSet(j,p);
	}

	public static void unionSet(int i,int j,int[] p,int[] rank)
	{
		int x = findSet(i,p);
		int y = findSet(j,p);
		if(!isSameSet(i,j,p))
		{
      if(rank[x]<rank[y])
      {
			 rank[y]+=rank[x];
       p[x]=y;
      }
      else
      {
        rank[x]+=rank[y];
        p[y]=x;
      }
    }
		
	}



	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String friend1;
		String friend2;
		int cases;
		int friendrequests;
    int[] p;
    int[] rank;
		HashMap<String,Integer> network;

		newline = stdin.readLine();
		st = new StringTokenizer(newline);
		cases = Integer.parseInt(st.nextToken());


		for(int i=0;i<cases;i++)
		{
			newline = stdin.readLine();
			st = new StringTokenizer(newline);
			friendrequests = Integer.parseInt(st.nextToken());
			p = new int[100000];
			rank = new int[100000];

			for(int j=0;j<friendrequests+1;j++)
			{
				p[j] = j;
				rank[j] = 1;
			}

			network = new HashMap<String,Integer>();
			int count = 0;

			for(int j=0;j<friendrequests;j++)
			{
				int friend1index=0;
				int friend2index=0;
				newline = stdin.readLine();
				st = new StringTokenizer(newline);
				friend1 = st.nextToken();
				friend2 = st.nextToken();

				if(!network.containsKey(friend1))
				{
          friend1index = count;
          network.put(friend1,count);
          count++;
				}
				else
				{
					friend1index = network.get(friend1);
				}

				if(!network.containsKey(friend2))
				{
          friend2index = count;
          network.put(friend2,count);
          count++;
				}
				else
				{
          friend2index = network.get(friend2);
				}

				unionSet(friend1index,friend2index,p,rank);
				sb.append(rank[findSet(friend1index,p)]).append("\n");

			}
		
		}

		System.out.print(sb);
	}
}
