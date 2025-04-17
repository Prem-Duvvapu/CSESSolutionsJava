import java.io.*;
import java.util.*;

public class ArrayDivision {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int k=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++)
            x[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(x,k,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] x,int k,int n,PrintWriter out) {
        long low=0;
        long high=0;
        long res=0;

        for (int i=0;i<n;i++) {
            low=Math.max(low,x[i]);
            high+=x[i];
        }

        res=high;

        while (low<=high) {
            long mid=low+(high-low)/2;
            if (isPossible(mid,x,k,n)) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        out.print(res);
    }

    public boolean isPossible(long currMinSum,int[] x,int k,int n) {
        int cuts=0;
        long currSum=0;

        for (int i=0;i<n;i++) {
            if (currSum+x[i]>currMinSum) {
                cuts++;
                currSum=x[i];
            } else {
                currSum+=x[i];
            }
        }

        return (cuts<k);
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