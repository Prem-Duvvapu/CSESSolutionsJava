import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BookShop {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] h=new int[n];
        int[] s=new int[n];

        for (int i=0;i<n;i++)
            h[i]=fr.nextInt();

        for (int i=0;i<n;i++)
            s[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(h,s,x,n,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    public void solve(int[] h,int[] s,int x,int n,PrintWriter out) {
        int[] prev=new int[x+1];
        int[] curr=new int[x+1];
        
        for (int pos=n-1;pos>=0;pos--) {
            for (int cost=1;cost<=x;cost++) {
                int pick=Integer.MIN_VALUE;
                if (cost>=h[pos])
                    pick=s[pos]+prev[cost-h[pos]];
                int notPick=prev[cost];

                curr[cost]=Math.max(pick,notPick);
            }

            for (int cost=1;cost<=x;cost++)
                prev[cost]=curr[cost];
        }

        out.println(prev[x]);
    }

    public int helper(int pos,int x,int[][] dp,int[] h,int[] s,int n) {
        if (x<0)
            return -1_000_000;

        if (x==0 || pos==n)
            return 0;

        if (dp[pos][x]!=-1)
            return dp[pos][x];

        int pick=s[pos]+helper(pos+1,x-h[pos],dp,h,s,n);
        int notPick=helper(pos+1,x,dp,h,s,n);

        return dp[pos][x]=Math.max(pick,notPick);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st==null || !st.hasMoreElements()) {
            try {
                st=new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str="";
        try {
            str=br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}