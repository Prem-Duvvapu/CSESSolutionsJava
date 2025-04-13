import java.io.*;
import java.util.*;

public class MinimizingCoins {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] c=new int[n];

        for (int i=0;i<n;i++)
            c[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(c,x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] c,int x,int n,PrintWriter out) {
        int[][] dp=new int[n+1][x+1];
        for (int i=0;i<=n;i++)
            for (int j=0;j<=x;j++)
                dp[i][j]=-1;

        

        int res=helper(n-1,x,dp,c,n);
        if (res>=(int)1e9)
            res=-1;

        out.println(res);
    }

    public int helper(int pos,int x,int[][] dp,int[] c,int n) {
        if (pos==0) {
            if (x%c[0]==0)
                return x/c[0];

            return (int)1e9;
        }

        if (dp[pos][x]!=-1)
            return dp[pos][x];

        int notPick=helper(pos-1,x,dp,c,n);
        int pick=(int)1e9;
        if (c[pos]<=x)
            pick=1+helper(pos,x-c[pos],dp,c,n);

        return dp[pos][x]=Math.min(pick,notPick);
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