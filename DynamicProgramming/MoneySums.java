import java.io.*;
import java.util.*;

public class MoneySums {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++) {
            x[i]=fr.nextInt();
        }

        Solution solution=new Solution();
        solution.solve(x,n,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    public void solve(int[] x,int n,PrintWriter out) {
        int totalSum=0;
        for (int val: x)
            totalSum+=val;

        boolean[][] dp=new boolean[n+1][totalSum+1];

        for (int i=0;i<=n;i++) {
            dp[i][0]=true;
        }

        for (int pos=n-1;pos>=0;pos--) {
            for (int target=1;target<=totalSum;target++) {
                boolean pick=false;
                if (target>=x[pos])
                    pick=dp[pos+1][target-x[pos]];

                boolean notPick=dp[pos+1][target];
                dp[pos][target]=(pick || notPick);
            }
        }

        int cnt=0;
        StringBuilder arr=new StringBuilder();
        for (int target=1;target<=totalSum;target++) {
            if (dp[0][target]) {
                cnt++;
                arr.append(target).append(" ");
            }
        }

        StringBuilder res=new StringBuilder();
        res.append(cnt).append("\n").append(arr);

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