import java.io.*;
import java.util.*;

public class SubarraySumsII {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] a=new int[n];

        for (int i=0;i<n;i++)
            a[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] a,int x,int n,PrintWriter out) {
        Map<Long,Integer> prefixSum=new HashMap<>();
        long currSum=0;
        long res=0;

        prefixSum.put(0L,1);

        for (int i=0;i<n;i++) {
            currSum+=a[i];

            if (prefixSum.containsKey(currSum-x))
                res+=prefixSum.get(currSum-x);

            prefixSum.put(currSum,prefixSum.getOrDefault(currSum, 0)+1);
        }

        out.print(res);
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