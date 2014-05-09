import java.io.*;
import java.util.*;
import java.math.*;

public class the-problem-with-the-problem-setter {


	public static int f,s;
	public static int[][] res;
	public static int[] p;
	public static int[][] finale;

	public static void augment(int v,int minEdge)
	{
		if(v==0)
		{
			f = minEdge;
			return;
		}
		else if(p[v]!=-1)
		{
			augment(p[v],Math.min(minEdge,res[p[v]][v]-finale[p[v]][v]));
			finale[p[v]][v]+=f;
			finale[v][p[v]]-=f;

		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int categories;
		int problems;
		int mf,s,t;
		int category;
		Queue<Integer> q;
		int count;
		int amount;
		int categoryamount;
		LinkedList<Integer>[] adj;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			if((categories = Integer.parseInt(st.nextToken()))!=0 && (problems = Integer.parseInt(st.nextToken()))!=0)
			{
				mf=0;
				s=0;
				t=problems+categories+1;
				finale = new int[t+1][t+1];
				adj = new LinkedList[t+1];

				for(int i=0;i<t+1;i++)
				{
					adj[i] = new LinkedList<Integer>();
				}


				count=0;
				res = new int[problems+categories+2][problems+categories+2];

				st = new StringTokenizer(stdin.readLine());
		
				for(int i=1;i<=categories;i++)
				{
					amount = Integer.parseInt(st.nextToken());
					res[problems+i][t]=amount;
					adj[problems+i].add(t);
					adj[t].add(problems+i);
					count+=amount;
				}

				for(int i=1;i<=problems;i++)
				{
					st = new StringTokenizer(stdin.readLine());
					categoryamount = Integer.parseInt(st.nextToken());
					for(int j=0;j<categoryamount;j++)
					{
						category = Integer.parseInt(st.nextToken());
						res[i][category+problems]=1;
						adj[i].add(category+problems);
						adj[category+problems].add(i);

					}
					res[s][i]=1;
					adj[s].add(i);
					adj[i].add(s);
				}

				while(true)
				{
					f=0;
					p = new int[problems+categories+2];
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
						Iterator itr = adj[u].iterator();
						while(itr.hasNext())
						{
							int v = (Integer)itr.next();
							if(res[u][v]-finale[u][v]>0 && p[v]==-1)
							{
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
					if(mf==count)
					{
						sb.append(1).append("\n");
						for(int i=1;i<=categories;i++)
						{
							for(int j=1;j<=problems;j++)
							{
								if(finale[j][problems+i]==1)
								{
									sb.append(j).append(" ");
								}
							}
							sb.append("\n");
						}
					}
					else
					{
						sb.append(0).append("\n");
					}

			}

		}
		System.out.print(sb);
	}

