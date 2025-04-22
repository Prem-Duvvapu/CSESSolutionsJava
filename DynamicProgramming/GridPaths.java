import java.io.*;
import java.util.*;

public class GridPaths {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        char[][] grid=new char[n][n];

        for (int i=0;i<n;i++)
            grid[i]=fr.nextLine().toCharArray();

        Solution solution=new Solution();
        solution.solve(grid,n,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    static final int MOD=1_000_000_000+7;

    public void solve(char[][] grid,int n,PrintWriter out) {
        int[][] dp=new int[n][n];
        for (int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);

        int res=helper(0,0,dp,grid,n);
        out.println(res);
    }

    public int helper(int r,int c,int[][] dp,char[][] grid,int n) {
        if (r<0 || r>=n || c<0 || c>=n)
            return 0;

        if (grid[r][c]=='*')
            return 0;

        if (r==n-1 && c==n-1)
            return 1;

        if (dp[r][c]!=-1)
            return dp[r][c];

        int right=helper(r,c+1,dp,grid,n)%MOD;
        int down=helper(r+1,c,dp,grid,n)%MOD;

        return dp[r][c]=(right+down)%MOD;
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