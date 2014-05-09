import java.io.*;
import java.util.*;
import java.math.*;

public class angry-programmer {

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
		int machines;
		int wires;
		int mf,s,t;
		Queue<Integer> q;
		int machine;
		int machine1;
		int machine2;
		int cost;
		LinkedList<Integer>[] adj;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			if((machines=Integer.parseInt(st.nextToken()))!=0)
			{
					wires = Integer.parseInt(st.nextToken());
					res = new int[2*(machines-2)+2][2*(machines-2)+2];

					mf = 0;
					s=0;
					t=2*(machines-2)+1;
					adj = new LinkedList[t+1];
					machine=0;

					for(int i=0;i<=t;i++)
					{
						adj[i] = new LinkedList<Integer>();
					}
					for(int i=0;i<machines-2;i++)
					{
						st = new StringTokenizer(stdin.readLine());
						machine = Integer.parseInt(st.nextToken());
						res[machine-1][machine-1+(machines-2)]=Integer.parseInt(st.nextToken());

						adj[machine-1].add(machine-1+(machines-2));
						adj[machine-1+(machines-2)].add(machine-1);
					}
					for(int i=0;i<wires;i++)
					{
						st = new StringTokenizer(stdin.readLine());
						machine1 = Integer.parseInt(st.nextToken());
						machine2 = Integer.parseInt(st.nextToken());
						cost = Integer.parseInt(st.nextToken());
						if(machine1==1)
						{
							if(machine2==machines)
							{
								res[s][t]=cost;
								res[s][t]=cost;

								adj[s].add(t);
								adj[t].add(s);
							}
							else
							{
								res[s][machine2-1]=cost;
								res[machine2-1+(machines-2)][s]=cost;

								adj[s].add(machine2-1);
								adj[machine2-1].add(s);

								adj[machine2-1+(machines-2)].add(s);
								adj[s].add(machine2-1+(machines-2));
							}
						}
						else if(machine2==machines)
						{
							res[machine1-1+(machines-2)][t]=cost;
							res[t][machine1-1]=cost;

							adj[machine1-1+(machines-2)].add(t);
							adj[t].add(machine1-1+(machines-2));

							adj[t].add(machine1-1);
							adj[machine1-1].add(t);
						}
						else
						{
							res[machine1-1+(machines-2)][machine2-1]=cost;
							res[machine2-1+(machines-2)][machine1-1]=cost;

							adj[machine1-1+(machines-2)].add(machine2-1);
							adj[machine2-1].add(machine1-1+(machines-2));

							adj[machine2-1+(machines-2)].add(machine1-1);
							adj[machine1-1].add(machine2-1+(machines-2));
						}

					}
						

					while(true)
					{
						f=0;
						p = new int[2*(machines-2)+2];
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
								if(res[u][v]>0 && p[v]==-1)
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
					sb.append(mf).append("\n");
				}
		}

		System.out.print(sb);
	}

}
