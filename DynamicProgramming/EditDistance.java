import java.io.*;
import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        String s1=fr.nextLine();
        String s2=fr.nextLine();

        Solution solution=new Solution();
        solution.solve(s1,s2,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    public void solve(String s1,String s2,PrintWriter out) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];

        for (int j=0;j<m;j++)
            dp[n][j]=m-j;

        for (int i=0;i<n;i++)
            dp[i][m]=n-i;

        for (int i=n-1;i>=0;i--) {
            for (int j=m-1;j>=0;j--) {
                if (s1.charAt(i)==s2.charAt(j)) {
                    dp[i][j]=dp[i+1][j+1];
                    continue;
                }

                int moveS1=1+dp[i][j+1];
                int moveS2=1+dp[i+1][j];
                int replace=1+dp[i+1][j+1];

                dp[i][j]=Math.min(replace,Math.min(moveS1,moveS2));
            }
        }

        int res=dp[0][0];
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