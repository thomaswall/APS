import java.io.*;
import java.util.*;
import java.math.*;

public class dark-roads {

		public static class Edge implements Comparable<Edge>
		{
			int A,B,w;

			public Edge(int A,int B, int w)
			{
				this.A = Math.min(A,B);
				this.B = Math.max(A,B);
				this.w = w;
			}

			public int compareTo(Edge e)
			{
				if(w!=e.w)
				{
					return w < e.w ? -1 : 1;
				}
				else
				{
					return 0;
				}
			}
		}

public static class UnionFind {

		int uf[];

		public UnionFind(int size)
		{
			uf = new int[size];
			for(int i=0;i<size;i++)
			{
				uf[i]=i;
			}
		}

		public boolean isSameSet(int A, int B)
		{
			return find(A)==find(B);
		}

		public void union(int A, int B)
		{
			uf[find(A)] = find(B);
		}

		public int find(int A)
		{
			int res = uf[A];
			while(uf[res]!=res)
			{
				res = uf[res];
			}
			return uf[A] = res;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int junctions;
		int roads;
		ArrayList<Edge> edgeList;
		int mstCost;
		int j1,j2,weight,total;


		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			edgeList = new ArrayList<Edge>();
			if((junctions = Integer.parseInt(st.nextToken()))!=0)
			{
				if((roads = Integer.parseInt(st.nextToken()))!=0)
				{
					total = 0;
					for(int i=0;i<roads;i++)
					{
						st = new StringTokenizer(stdin.readLine());
						j1 = Integer.parseInt(st.nextToken());
						j2 = Integer.parseInt(st.nextToken());
						weight = Integer.parseInt(st.nextToken());
						total+=weight;
						edgeList.add(new Edge(j1,j2,weight));
					}
					Collections.sort(edgeList);
					mstCost = 0;
					UnionFind uf = new UnionFind(junctions);

					for(Edge e : edgeList)
					{
						if(!uf.isSameSet(e.A,e.B))
						{
							mstCost += e.w;
							uf.union(e.A,e.B);
						}
					}
					sb.append(total-mstCost).append("\n");
				}
			}
		}
		System.out.print(sb);
	
	}

}
