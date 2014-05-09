import java.io.*;
import java.util.*;
import java.math.*;
import java.text.*;

public class complex-numbers {

	static final double EPS = 1e-9;
	static class Complex implements Comparable
	{
		float a=0;
		float b=0;

		public Complex(float a,float b)
		{
			this.a=a;
			this.b=b;
		}

		@Override
		public int compareTo(Object o)
		{
			Complex other = (Complex)o;
			if (Math.abs(other.a-this.a) > EPS) return other.a < this.a ? -1 : 1;
			if (Math.abs(other.b-this.b) > EPS) return other.b < this.b ? -1 : 1;
			return 0;
		}

	}

	static String[] format(float a,float b)
	{
		String as = String.format("%.03f",a), bs = String.format("%+.03f",b);
		if (as.equals("-0.000")) as = "0.000";
		if (bs.equals("-0.000")) bs = "+0.000";
		return new String[]{as,bs};
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String newline;
		String entry;
		int a,b,n;
		double r,theta;
		Complex[] sorting;
		int counter=0;
		boolean a_neg=false;
		DecimalFormat df = new DecimalFormat("#0.000");
		String[] parts;


		while((newline=stdin.readLine())!=null)
		{
			st = new StringTokenizer(newline);
			entry = st.nextToken().replaceAll("i","");
			n = Integer.parseInt(st.nextToken());
			if(entry.charAt(0)=='-')
			{
				a_neg=true;
				entry = entry.substring(1);
			}
			parts = entry.split("-");
			if(parts.length==1)
			{
				parts = entry.split("\\+");
				b=Integer.parseInt(parts[1]);
			}
			else
			{
				b=-Integer.parseInt(parts[1]);
			}

			if(a_neg)
			{
				a=-Integer.parseInt(parts[0]);
			}
			else
			{
				a=Integer.parseInt(parts[0]);
			}
			counter++;
			sorting = new Complex[n];
			r=Math.sqrt(a*a+b*b);
			theta = Math.atan2(b,a);
			for(int k=0;k<n;k++)
			{
				sorting[k]=new Complex((float)(Math.pow(r,(double)1/n)*Math.cos((theta+2*Math.PI*k)/n)),(float)(Math.pow(r,(double)1/n)*Math.sin((theta+2*Math.PI*k)/n)));
			}
			Arrays.sort(sorting);
			sb.append("Case ").append(counter).append(":\n");
			for(int k=0;k<n;k++)
			{
				String[] temp = format(sorting[k].a,sorting[k].b);
				sb.append(temp[0]).append(temp[1]).append("i").append("\n");
			}
			a_neg = false;
			sb.append("\n");
			


		}
		System.out.print(sb);

		

	}
}
