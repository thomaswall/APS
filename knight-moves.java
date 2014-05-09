import java.io.*;
import java.util.*;
import java.math.*;

class Move
{
	public int first=0;
	public int second=0;
	public int move=0;

	public Move(int first,int second,int move)
	{
		this.first = first;
		this.second = second;
		this.move = move;
	}
}

public class knight-moves {

static	public int morph(char c)
{
	if(c=='a')
	{
		return 0;
	}
	else if(c=='b')
	{
		return 1;
	}
	else if(c=='c')
	{
		return 2;
	}
	else if(c=='d')
	{
		return 3;
	}
	else if(c=='e')
	{
		return 4;
	}
	else if(c=='f')
	{
		return 5;
	}
	else if(c=='g')
	{
		return 6;
	}
	else
	{
		return 7;
	}
}

static public boolean valid(int a,int b)
{
	if(a<0 || a>7 || b<0 || b>7)
	{
		return false;
	}
	else
	{
		return true;
	}
}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		String coordinate1,coordinate2;
		int coordinate1_x,coordinate1_y,coordinate2_x,coordinate2_y;
		int goal_x=-1;
		int goal_y=-1;
		Queue<Move> queue;
		Move knight= new Move(-1,-1,-1);


		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			coordinate1 = st.nextToken();
			coordinate2 = st.nextToken();
			coordinate2_x = morph(coordinate2.charAt(0));
			coordinate2_y = (int)(coordinate2.charAt(1)-'0')-1;
			queue = new LinkedList<Move>();
			queue.add(new Move(morph(coordinate1.charAt(0)),(int)(coordinate1.charAt(1)-'0')-1,0));

			while(goal_x!=coordinate2_x || goal_y!=coordinate2_y)
			{
				knight = queue.poll();
				goal_x = knight.first;
				goal_y = knight.second;
				if(valid(goal_x+2,goal_y-1))
				{
					queue.add(new Move(goal_x+2,goal_y-1,knight.move+1));
				}
				if(valid(goal_x+2,goal_y+1))
				{
					queue.add(new Move(goal_x+2,goal_y+1,knight.move+1));
				}
				if(valid(goal_x-1,goal_y+2))
				{
					queue.add(new Move(goal_x-1,goal_y+2,knight.move+1));
				}
				if(valid(goal_x+1,goal_y+2))
				{
					queue.add(new Move(goal_x+1,goal_y+2,knight.move+1));
				}
				if(valid(goal_x+1,goal_y-2))
				{
					queue.add(new Move(goal_x+1,goal_y-2,knight.move+1));
				}
				if(valid(goal_x-1,goal_y-2))
				{
					queue.add(new Move(goal_x-1,goal_y-2,knight.move+1));
				}
				if(valid(goal_x-2,goal_y-1))
				{
					queue.add(new Move(goal_x-2,goal_y-1,knight.move+1));
				}
				if(valid(goal_x-2,goal_y+1))
				{
					queue.add(new Move(goal_x-2,goal_y+1,knight.move+1));
				}

			}

			sb.append("To get from ").append(coordinate1).append(" to ").append(coordinate2).append(" takes ").append(knight.move).append(" knight moves.\n");


		}
		System.out.print(sb);

		

	}
}
