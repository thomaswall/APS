import java.io.*;
import java.util.*;
import java.math.*;

class FTree
{
		int[] FT;
		FTree(int size)
		{
			FT = new int[size+1];
		}
		int LSO(int x)
		{
			return x&(-x);
		}
		int rsq(int x)
		{
			int sum=0;
			for(;x>0;x-=LSO(x))
			{
				sum+= FT[x];
			}
			return sum;
		}
		int rsq(int x, int y)
		{
			return rsq(y) - (x==1 ? 0 : rsq(x-1));
		}
		void upd(int x,int inc)
		{
			for(;x<FT.length;x+=LSO(x))
			{
				FT[x]+=inc;
			}
		}
}

class interval-product {

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String newline;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int total;
		int changes;
		String operation;
		int placement;
		int newnumber;
		int input;
		HashMap<Integer,Integer> list;

		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			total = Integer.parseInt(st.nextToken());
			changes = Integer.parseInt(st.nextToken());
			list = new HashMap<Integer,Integer>();
			FTree FTreeNegatives = new FTree(total);
			FTree FTreeZeros = new FTree(total);

			st = new StringTokenizer(stdin.readLine());

			for(int i=1;i<total+1;i++)
			{
				if((input=Integer.parseInt(st.nextToken()))<0)
				{
					FTreeNegatives.upd(i,1);
				}
				else if(input==0)
				{
					FTreeZeros.upd(i,1);
				}
				list.put(i,input);
			}

			for(int i=0;i<changes;i++)
			{
				st = new StringTokenizer(stdin.readLine());
				operation = st.nextToken();
				placement = Integer.parseInt(st.nextToken());
				newnumber = Integer.parseInt(st.nextToken());
				if(operation.equals("C"))
				{
					if(list.get(placement)>=0 && newnumber<0)
					{
						FTreeNegatives.upd(placement,1);
					}
					else if(list.get(placement)<0 && newnumber>=0)
					{
						FTreeNegatives.upd(placement,-1);
					}

					if(list.get(placement)!=0 && newnumber==0)
					{
						FTreeZeros.upd(placement,1);
					}
					else if(list.get(placement)==0 && newnumber != 0)
					{
						FTreeZeros.upd(placement,-1);
					}

					list.put(placement,newnumber);
				}
				else
				{
					if(FTreeZeros.rsq(placement,newnumber)!=0)
					{
						sb.append('0');
					}
					else if(FTreeNegatives.rsq(placement,newnumber) % 2 == 0)
					{
						sb.append('+');
					}
					else if(FTreeNegatives.rsq(placement,newnumber) % 2 != 0)
					{
						sb.append('-');
					}
				}
			}
			sb.append("\n");
		}
		

		System.out.print(sb);
	}
}
