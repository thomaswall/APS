import java.io.*;
import java.util.*;
import java.math.*;

public class wheres-waldorf {
	static char dp[][];
	static StringBuilder sb = new StringBuilder();
	static int rows;
	static int columns;
	static boolean check;
	static int first_row;
	static int first_column;

	public static void searcher(String search,int row,int column,int index,int dir,int rows,int columns)
	{
		if(dp[row][column]==search.charAt(index))
		{
			if(index==(search.length()-1))
			{
				sb.append(first_row).append(" ").append(first_column).append("\n");
				check = true;
				return;
			}
			else
			{
				if(dir==0 && row+1<rows && column+1<columns)
				{
					searcher(search,row+1,column+1,index+1,dir,rows,columns);
				}
				else if(dir==1 && row+1<rows)
				{
					searcher(search,row+1,column,index+1,dir,rows,columns);
				}
				else if(dir==2 && column+1<columns)
				{
					searcher(search,row,column+1,index+1,dir,rows,columns);
				}
				else if(dir==3 && row-1>=0 && column-1>=0)
				{
					searcher(search,row-1,column-1,index+1,dir,rows,columns);
				}
				else if(dir==4 && column-1>=0)
				{
					searcher(search,row,column-1,index+1,dir,rows,columns);
				}
				else if(dir==5 && row-1>=0)
				{
					searcher(search,row-1,column,index+1,dir,rows,columns);
				}
				else if(dir==6 && row-1>=0 && column+1<columns)
				{
					searcher(search,row-1,column+1,index+1,dir,rows,columns);
				}
				else if(dir==7 && row+1<rows && column-1>=0)
				{
					searcher(search,row+1,column-1,index+1,dir,rows,columns);
				}
				else
				{
					return;
				}

			}
		}
		else
		{
			return;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int rows;
		int columns;
		String line;
		int searches;
		String search;

		st = new StringTokenizer(stdin.readLine());
		int cases = Integer.parseInt(st.nextToken());
		for(int i=0;i<cases;i++)
		{
			st = new StringTokenizer(stdin.readLine());
			st = new StringTokenizer(stdin.readLine());
			rows = Integer.parseInt(st.nextToken());
			columns = Integer.parseInt(st.nextToken());
			dp = new char[rows][columns];

			for(int j=0;j<rows;j++)
			{
				line = stdin.readLine().toLowerCase();
				for(int k=0;k<columns;k++)
				{
					dp[j][k]=line.charAt(k);
				}
			}

			st = new StringTokenizer(stdin.readLine());
			searches = Integer.parseInt(st.nextToken());
			for(int j=0;j<searches;j++)
			{
				check = false;
				search = stdin.readLine().toLowerCase();
				for(int k=0;k<rows;k++)
				{
					for(int l=0;l<columns;l++)
					{
						if(dp[k][l]==search.charAt(0))
						{
							first_row=k+1;
							first_column=l+1;

							if(search.length()==1)
							{
								sb.append(first_row).append(" ").append(first_column).append("\n");
							}
							else
							{
								if(k+1<rows && l+1<columns && dp[k+1][l+1]==search.charAt(1))
								{
									searcher(search,k+1,l+1,1,0,rows,columns);
								}
								if(k+1<rows && dp[k+1][l]==search.charAt(1))
								{
									searcher(search,k+1,l,1,1,rows,columns);
								}
								if(l+1<columns && dp[k][l+1]==search.charAt(1))
								{
									searcher(search,k,l+1,1,2,rows,columns);
								}
								if(k-1>=0 && l-1>=0 && dp[k-1][l-1]==search.charAt(1))
								{
									searcher(search,k-1,l-1,1,3,rows,columns);
								}
								if(l-1>=0 && dp[k][l-1]==search.charAt(1))
								{
									searcher(search,k,l-1,1,4,rows,columns);
								}
								if(k-1>=0 && dp[k-1][l]==search.charAt(1))
								{
									searcher(search,k-1,l,1,5,rows,columns);
								}
								if(k-1>=0 && l+1<columns && dp[k-1][l+1]==search.charAt(1))
								{
									searcher(search,k-1,l+1,1,6,rows,columns);
								}
								if(k+1<rows && l-1>=0 && dp[k+1][l-1]==search.charAt(1))
								{
									searcher(search,k+1,l-1,1,7,rows,columns);
								}
							}
						}
						if(check)
						{
							break;
						}
					}

					if(check)
					{
						break;
					}
				}

			}

		if(i!=cases-1)
		{
			sb.append("\n");
		}
		}
		System.out.print(sb);
	}

}
