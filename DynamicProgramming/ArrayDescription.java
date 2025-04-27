import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayDescription {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int m=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++)
            x[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(x,m,n,out);

        out.close();
    }
}

class Solution {
    static final int MOD = 1_000_000_000 + 7;

    public void solve(int[] x, int m, int n, PrintWriter out) {
        int[][] dp = new int[n][m + 2];

        // base case
        if (x[0] == 0) {
            for (int val = 1; val <= m; val++) {
                dp[0][val] = 1;
            }
        } else {
            dp[0][x[0]] = 1;
        }

        for (int pos = 1; pos<n; pos++) {
            int totalWays=0;

            if (x[pos]!=0) {
                totalWays=(totalWays+dp[pos-1][x[pos]-1])%MOD;
                totalWays=(totalWays+dp[pos-1][x[pos]])%MOD;
                totalWays=(totalWays+dp[pos-1][x[pos]+1])%MOD;

                dp[pos][x[pos]]=totalWays;
            } else {
                for (int currVal = 1; currVal <= m; currVal++) {
                    totalWays=0;
                    totalWays=(totalWays+dp[pos-1][currVal-1])%MOD;
                    totalWays=(totalWays+dp[pos-1][currVal])%MOD;
                    totalWays=(totalWays+dp[pos-1][currVal+1])%MOD;

                    dp[pos][currVal]=totalWays;
                }
            }
        }

        int res = 0;
        for (int currVal = 1; currVal <= m; currVal++)
            res = (res + dp[n-1][currVal]) % MOD;
            

        out.println(res);
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