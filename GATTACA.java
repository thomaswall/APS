import java.io.*;
import java.util.*;
import java.math.*;

/**
 * Suffix Tree.
 */
class SuffixTree
{
	public static final int INF = Integer.MAX_VALUE-1;
	public int last;
	public String str;
	public Node root, sentinel;

	/**
	 * Edge of the SuffixTree.  
	 */
	public class Edge
	{
		/** An inclusive range [a,b] of indices into str representing the edge label. */
		public int a, b;
		/** Node where the edge points to */
		public Node end;
		public Edge(int a, int b, Node end) { this.a = a; this.b = b; this.end = end; }
		/** Returns the first character on the edge. */
		public char getFirst() { return str.charAt(a); }
		/** Length of the string on the edge label. */
		public int length() { return Math.min(last,b) - a + 1; } 
		@Override
		public String toString() { return str.substring(a, Math.min(b,last)+1); }
	}
	/**
	 * Node of the SuffixTree.
	 */
	public class Node implements Iterable<Edge>
	{
		/** Maps first letters to edges leading to children */
		public TreeMap<Character,Edge> edges = new TreeMap<Character,Edge>();
		/** Suffix link used in linear tree building algorithm */
		private Node suffix;
		/** An inclusive range [a,b] of indices into str representing a prefix leading to this node */
		public int a, b;
		/** Adds an edge to the map */
		public void add(Edge e) { edges.put(e.getFirst(),e); }
		/** Gets the edge using the given first character */
		public Edge get(char c) { return edges.get(c); }
		/** Returns the number of children */
		public int numChildren() { return edges.size(); }
		@Override
		public Iterator<Edge> iterator() { return edges.values().iterator(); }
		public String toString() { return str.substring(a,Math.min(b,last)+1); }
	}
	public SuffixTree(String str)
	{
		this.str = str;
		buildTree();
		setPrefix(root,null,0);
	}
	@Override
	/** Pretty prints the tree.  For each node it prints the prefix leading to that node in quotes.
	 * Then it prints each edge leaving the node indexed by first letter, the edge label, the inclusive range of indices,
	 * and the length of the label.
	 */
	public String toString() { return prettyFormat(new StringBuilder(), root, new StringBuilder()).toString(); }
	private int fix(int x) { return x == INF ? last : x; }
	private StringBuilder prettyFormat(StringBuilder sb, Node n, StringBuilder tab)
	{
		sb.append(tab).append('"').append(n).append('"').append('\n');
		for (Edge e : n)
		{
			char c = e.getFirst();
			sb.append(tab).append(c).append(" : ").append(e).append(" = ").append(e.a).append(',').append(fix(e.b)).append(',').append(e.length()).append('\n');
			tab.append("  ");
			prettyFormat(sb,e.end,tab);
			tab.delete(tab.length()-2, tab.length());
		}
		return sb;
	}
	/** Returns the string used to make the suffix tree */
	public String getStr() { return str; }
	/** Returns the root node */
	public Node getRoot() { return root; }
	private void setPrefix(Node n, Edge e, int len)
	{
		for (Edge edge : n) setPrefix(edge.end,edge,len+Math.min(edge.b,last)-edge.a+1);
		if (e == null) { n.a = 0; n.b = -1; }
		else { n.b = Math.min(e.b,last); n.a = n.b - len+1; }
	}
	private void buildTree()
	{
		root = new Node();
		sentinel = new Node();
		root.suffix = sentinel;
		Node s = root;
		int[] k = {0};
		last = -1;
		for (int i = 0; i < str.length(); ++i)
		{
			last++;
			s = update(s,k,i);
			s = canonize(s,k,i);
		}
	}
	private Node update(Node s, int[] k, int i)
	{
		Node oldr = root, r = testAndSplit(s,k[0],i-1,str.charAt(i));
		while (r != null)
		{
			Node rp = new Node();
			Edge e = new Edge(i,INF,rp);
			r.add(e);
			if (oldr != root) oldr.suffix = r;
			oldr = r;
			s = canonize(s.suffix,k,i-1);
			r = testAndSplit(s,k[0],i-1,str.charAt(i));
		}
		if (oldr != root) oldr.suffix = s;
		return s;
	}
	private Node testAndSplit(Node s, int k, int p, char c)
	{
		if (k > p) return s == sentinel ? null : s.get(c) == null ? s : null;
		Edge e = s.get(str.charAt(k));
		if (c == str.charAt(e.a+p-k+1)) return null; //check if char after implicit node is c
		Node r = new Node();
		Edge re = new Edge(e.a+p-k+1,e.b,e.end);
		r.add(re);
		Edge se = new Edge(e.a,e.a+p-k,r);
		s.add(se);
		return r;
	}
	private Node canonize(Node s, int[] k, int p)
	{
		if (p < k[0]) return s;
		if (s == sentinel) { s = root; k[0]++; if (p < k[0]) return s; }
		Edge e = s.get(str.charAt(k[0]));
		while (e.b - e.a <= p - k[0])
		{
			k[0] = k[0] + e.b - e.a + 1;
			s = e.end;
			if (k[0] <= p) e = s.get(str.charAt(k[0]));
		}
		return s;
	}
	/** Can be used to test the suffix tree on a given string given as a cmdline argument. */

	public int dfs1(Node n)
	{
		int max=n.toString().length();

		for (Edge e : n)
		{
			int temp = dfs1(e.end);
			if(max<temp)
			{
				max = temp;
			}
		}
		if(n.numChildren()==0)
		{
			return 0;
		}
		else
		{
			return max;
		}
	}

	public String dfs2(Node n,int x, String answer)
	{
		if(n.toString().length()==x && n.toString().charAt(x-1)!='$')
		{
			return n.toString() + " " + n.numChildren();
		}
		for (Edge e : n)
		{
			answer = dfs2(e.end,x,"");
			if(answer.length()>=x) break;
		}
		return answer;
	}
}

public class GATTACA {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		SuffixTree suffix;
		int length;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			line = st.nextToken();
			suffix = new SuffixTree(line+"$");
			length = suffix.dfs1(suffix.root);
			if(length==0)
			{
				sb.append("No repetitions found!").append("\n");
			}
			else
			{	
				sb.append(suffix.dfs2(suffix.root,length,"")).append("\n");
			}
			
		}
		System.out.print(sb);

	}
}
