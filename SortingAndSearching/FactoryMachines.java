import java.io.*;
import java.util.*;

public class FactoryMachines {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int t=fr.nextInt();
        int[] k=new int[n];

        for (int i=0;i<n;i++)
            k[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(k,t,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] k,int t,int n,PrintWriter out) {
        int minVal=Integer.MAX_VALUE;

        for (int i=0;i<n;i++)
            minVal=Math.min(minVal,k[i]);

        long low=0;
        long high=(long)minVal*t;
        long res=high;

        while (low<=high) {
            long mid=low+(high-low)/2;

            if (isPossible(mid,k,t,n)) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        out.print(res);
    }

    public boolean isPossible(long currTime,int[] k,int t,int n) {
        long currTotalProducts=0;

        for (int i=0;i<n;i++) {
            currTotalProducts+=(currTime/k[i]);

            if (currTotalProducts>=(long)t)
                return true;
        }

        return false;
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