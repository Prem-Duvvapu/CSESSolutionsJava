import java.io.*;
import java.util.*;

public class CoinCombinationsI {
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
    public static final int MOD=1_000_000_007;

    public void solve(int[] c,int x,int n,PrintWriter out) {
        Arrays.sort(c);
        int[] dp=new int[x+1];
        dp[0]=1;

        for (int target=1;target<=x;target++) {
            for (int i=0;i<n;i++) {
                if (c[i]>target)
                    break;

                dp[target]=(dp[target]+dp[target-c[i]])%MOD;
            }
            
            // System.out.println(target+" "+Arrays.toString(dp));
        }
        
        out.print(dp[x]);
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