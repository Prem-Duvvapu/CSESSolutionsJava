import java.io.*;
import java.util.*;

public class RemovingDigits {
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
    //write the logic here
    public void solve(int n,PrintWriter out) {
        int[] dp=new int[n+1];

        for (int i=1;i<=n;i++) {
            int temp=i;
            int minSteps=Integer.MAX_VALUE;

            while (temp>0) {
                int digit=temp%10;
                
                int curr=Integer.MAX_VALUE;
                if (digit!=0 && digit<=temp)
                    curr=1+dp[i-digit];
    
                minSteps=Math.min(minSteps,curr);
                temp/=10;
            }

            dp[i]=minSteps;
        }

        // out.println(Arrays.toString(dp));

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