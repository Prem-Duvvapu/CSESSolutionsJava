import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TwoSetsII {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(n,out);

        out.close();
    }
}

class Solution {
    static final int MOD=1_000_000_000 + 7;

    //write the logic here
    public void solve(int n,PrintWriter out) {
        int totalSum=(n*(n+1))/2;
        if ((totalSum&1)==1) { //odd 
            out.println(0);
            return;
        }

        int halfSum=totalSum/2;
        int[][] dp=new int[n][halfSum+1];

        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        int res=helper(1,halfSum,dp,n);
        out.println(res);
    }

    public int helper(int curr,int target,int[][] dp,int n) {
        if (target==0)
            return 1;

        if (curr>target || curr==n)
            return 0;

        if (dp[curr][target]!=-1)
            return dp[curr][target];
        
        int pick=helper(curr+1,target-curr,dp,n);
        int notPick=helper(curr+1,target,dp,n);

        return dp[curr][target]=(pick+notPick)%MOD;
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