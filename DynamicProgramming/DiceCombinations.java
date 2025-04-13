import java.io.*;
import java.util.*;

public class DiceCombinations {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(n,out);

        out.close();
    }
}

class Solution {
    long mod=(long)1e9+7;

    public void solve(int n,PrintWriter out) {
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;

        for (int k=1;k<=n;k++) {
            long numOfWays=0;

            for (int i=1;i<=6;i++) {
                if (i<=k)
                    numOfWays=numOfWays+dp[k-i];
            }

            dp[k]=numOfWays%mod;
        }
        
        out.println(dp[n]);
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