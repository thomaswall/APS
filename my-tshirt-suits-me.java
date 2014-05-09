import java.io.*;
import java.util.*;
import java.math.*;

public class my-tshirt-suits-me {

	public static int f,s;
	public static int[][] res;
	public static int[] p;

	public static void augment(int v,int minEdge)
	{
		if(v==0)
		{
			f = minEdge;
			return;
		}
		else if(p[v]!=-1)
		{
			augment(p[v],Math.min(minEdge,res[p[v]][v]));
			res[p[v]][v]-=f;
			res[v][p[v]]+=f;
		}
	}


	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tshirts;
		int people;
		int mf,s,t;
		String tshirt1,tshirt2;
		int[] dist;
		Queue<Integer> q;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int j=0;j<cases;j++)
		{
			st = new StringTokenizer(stdin.readLine());
			tshirts = Integer.parseInt(st.nextToken());
			people = Integer.parseInt(st.nextToken());

			res = new int[tshirts+people+2][tshirts+people+2];

			mf = 0;
			s=0;
			t=6+people+1;

			for(int i=1;i<7;i++)
			{
				res[s][i]=tshirts/6;
			}

			for(int i=0;i<people;i++)
			{
				st = new StringTokenizer(stdin.readLine());
				tshirt1 = st.nextToken();
				tshirt2 = st.nextToken();

				if(tshirt1.equals("XS"))
				{
					res[1][i+7]=1;
				}
				else if(tshirt1.equals("S"))
				{
					res[2][i+7]=1;
				}
				else if(tshirt1.equals("M"))
				{
					res[3][i+7]=1;
				}
				else if(tshirt1.equals("L"))
				{
					res[4][i+7]=1;
				}
				else if(tshirt1.equals("XL"))
				{
					res[5][i+7]=1;
				}
				else if(tshirt1.equals("XXL"))
				{
					res[6][i+7]=1;
				}

				if(tshirt2.equals("XS"))
				{
					res[1][i+7]=1;
				}
				else if(tshirt2.equals("S"))
				{
					res[2][i+7]=1;
				}
				else if(tshirt2.equals("M"))
				{
					res[3][i+7]=1;
				}
				else if(tshirt2.equals("L"))
				{
					res[4][i+7]=1;
				}
				else if(tshirt2.equals("XL"))
				{
					res[5][i+7]=1;
				}
				else if(tshirt2.equals("XXL"))
				{
					res[6][i+7]=1;
				}

			}
			

			for(int i=7;i<7+people;i++)
			{
				res[i][7+people]=1;
			}

			while(true)
			{
				f=0;
				dist = new int[people+tshirts+2];
				p = new int[people+tshirts+2];
				Arrays.fill(dist,Integer.MAX_VALUE);
				dist[s]=0;
				q = new LinkedList<Integer>();
				q.add(s);
				Arrays.fill(p,-1);
				while(!q.isEmpty())
				{
					int u = q.poll();
					if(u==t)
					{
						break;
					}
					for(int v=0;v<tshirts+people+2;v++)
					{
						if(res[u][v]>0 && dist[v]==Integer.MAX_VALUE)
						{
							dist[v]=dist[u]+1;
							q.add(v);
							p[v]=u;
						}
					}
				}

				augment(t,Integer.MAX_VALUE);
				if(f==0)
				{
					break;
				}
				mf+=f;

			}
			if(mf==people)
			{
				sb.append("YES\n");
			}
			else
			{
				sb.append("NO\n");
			}
		}

		

		System.out.print(sb);
	}

}
