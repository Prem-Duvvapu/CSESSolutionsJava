import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RemovalGame {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++)
            x[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(x,n,out);

        out.close();
    }
}

// Reference: https://codeforces.com/blog/icecuber
class Solution {
    static final int MOD=1_000_000_000 + 7;
    
    //write the logic here
    public void solve(int[] x,int n,PrintWriter out) {
        long totalSum=0L; //score1+score2

        for (int val: x)
            totalSum+=val;

        long[][] dp=new long[n][n];

        for (int l=n-1;l>=0;l--) {
            for (int r=l;r<n;r++) {
                if (l==r) {
                    dp[l][r]=x[l];
                } else {
                    dp[l][r]=Math.max(
                            x[l]-dp[l+1][r],
                            x[r]-dp[l][r-1]
                        );
                }
            }
        }

        long res=(totalSum+dp[0][n-1])/2; // (score1+score2+score1-score)/2
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