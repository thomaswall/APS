import java.io.*;
import java.util.*;
import java.math.*;

public class unlock-the-lock {

	public static int bfs(ArrayList<Integer> adj,int l,int u)
	{
		Queue<Integer> queue = new ArrayDeque<Integer>();
		HashMap<Integer,Integer> levels = new HashMap<Integer,Integer>();
		queue.add(l);
		int level=0;
		levels.put(l,level);
		int done = -1;
		boolean[] state = new boolean[10001];
		while(!queue.isEmpty())
		{
			int v = queue.poll();
			level = levels.get(v);
			if(v==u)
			{
				done=level;
				break;
			}
			else
			{
				for(int i=0;i<adj.size();i++)
				{
					if(state[(v+adj.get(i))%10000]==false)
					{
						queue.add((v+adj.get(i))%10000);
						state[(v+adj.get(i))%10000]=true;
						levels.put((v+adj.get(i))%10000,level+1);
					}
				}
			}
		}
		return done;
		
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int l;
		int u;
		int r;
		ArrayList<Integer> adj;
		int count=1;

		while((newline = stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			l = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			adj = new ArrayList<Integer>();

			if(!(r==0 && l==0 && u==0))
			{
				st = new StringTokenizer(stdin.readLine());
				for(int i=0;i<r;i++)
				{
					adj.add(Integer.parseInt(st.nextToken()));
				}
				int found = bfs(adj,l,u);

				if(found==-1)
				{
					sb.append("Case ").append(count).append(": ").append("Permanently Locked\n");
				}
				else
				{
					sb.append("Case ").append(count).append(": ").append(found).append("\n");
				}
				count++;

			}
		}
		System.out.print(sb);
	}

}
