import java.io.*;
import java.util.*;

public class MissingCoinSum {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] coins=new int[n];

        for (int i=0;i<n;i++)
            coins[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(coins,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] coins,int n,PrintWriter out) {
        Arrays.sort(coins);
        long sum=0;
        long res=0;

        for (int i=0;i<n;i++) {
            if (coins[i]>sum+1) {
                res=sum+1;
                out.println(res);
                return;
            }

            sum+=coins[i];
        }

        out.println(sum+1);
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