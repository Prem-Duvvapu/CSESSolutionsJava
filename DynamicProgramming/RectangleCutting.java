import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RectangleCutting {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int a=fr.nextInt();
        int b=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,b,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    public void solve(int a,int b,PrintWriter out) {
        int[][] dp=new int[501][501];
        for (int[] arr: dp)
            Arrays.fill(arr,-1);

        int res=helper(a,b,dp);
        System.out.println(res);
    }

    public int helper(int a,int b,int[][] dp) {
        if (a==0 || b==0 || a==b)
            return 0;

        if (a==1)
            return b-1;

        if (b==1)
            return a-1;

        if (dp[a][b]!=-1)
            return dp[a][b];

        if (dp[b][a]!=-1)
            return dp[b][a];

        int minCuts=Integer.MAX_VALUE;
        for (int i=1;i<a;i++) {
            int curr=1+helper(i,b,dp)+helper(a-i,b,dp);
            minCuts=Math.min(minCuts,curr);
        }

        for (int j=1;j<b;j++) {
            int curr=1+helper(a,j,dp)+helper(a,b-j,dp);
            minCuts=Math.min(minCuts,curr);
        }

        return dp[a][b]=dp[b][a]=minCuts;
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