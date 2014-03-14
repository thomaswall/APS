import java.io.*;
import java.util.*;
import java.math.*;

public class battleship {

	public static boolean getships(char[][] grid,boolean[][] visited,int i,int j,int dimension)
	{
		boolean alive = false;
		if(visited[i][j]==false)
		{
			visited[i][j]=true;
			if(grid[i][j]=='x')
			{
				alive = true;
				if(i-1>=0)
				{
					getships(grid,visited,i-1,j,dimension);
				}
				if(j-1>=0)
				{
					getships(grid,visited,i,j-1,dimension);
				}
				if(i+1<dimension)
				{
					getships(grid,visited,i+1,j,dimension);
				}
				if(j+1<dimension)
				{
					getships(grid,visited,i,j+1,dimension);
				}
			}
			else if(grid[i][j]=='@')
			{
				alive = false;
				if(i-1>=0)
				{
					alive = getships(grid,visited,i-1,j,dimension);
					if(alive==true)
					{
						return true;
					}
				}
				if(j-1>=0)
				{
					alive = getships(grid,visited,i,j-1,dimension);
					if(alive==true)
					{
						return true;
					}
				}
				if(i+1<dimension)
				{
					alive = getships(grid,visited,i+1,j,dimension);
					if(alive==true)
					{
						return true;
					}
				}
				if(j+1<dimension)
				{
					alive = getships(grid,visited,i,j+1,dimension);
					if(alive==true)
					{
						return true;
					}
				}
			}
		}
		return alive;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int dimension;
		int cases = Integer.parseInt(stdin.readLine());
		char[][] grid;
		boolean[][] visited;
		int count;

		for(int i=0;i<cases;i++)
		{
			dimension = Integer.parseInt(stdin.readLine());
			grid = new char[dimension][dimension];
			visited = new boolean[dimension][dimension];
			count=0;

			for(int j=0;j<dimension;j++)
			{
				newline = stdin.readLine();
				for(int k=0;k<dimension;k++)
				{
					grid[j][k]=newline.charAt(k);
				}
			}
			for(int j=0;j<dimension;j++)
			{
				for(int k=0;k<dimension;k++)
				{
					if(getships(grid,visited,j,k,dimension))
					{
						count++;
					}
				}
			}
			sb.append("Case ").append(i+1).append(": ").append(count).append("\n");
		}
		System.out.print(sb);
	}

}
