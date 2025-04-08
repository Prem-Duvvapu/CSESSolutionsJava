
import java.io.*;
import java.util.*;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        long[] arr=new long[n];

        for (int i=0;i<n;i++)
            arr[i]=fr.nextLong();

        Solution solution=new Solution();
        solution.solve(arr,n,out);

        out.close();
    }
}

class Solution {
    //Kadane's Algorithm
    public void solve(long[] arr,int n,PrintWriter out) {
        long maxSum=Integer.MIN_VALUE;
        long currSum=0;

        for (int i=0;i<n;i++) {
            currSum+=arr[i];
            maxSum=Math.max(maxSum,currSum);
            currSum=Math.max(currSum,0);
        }

        out.println(maxSum);
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