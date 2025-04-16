import java.io.*;
import java.util.*;

public class SubarrayDivisibility {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] a=new int[n];

        for (int i=0;i<n;i++)
            a[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] a,int n,PrintWriter out) {
        long res=0;
        Map<Integer,Integer> remFreq=new HashMap<>();
        remFreq.put(0,1);
        int currRem=0;

        for (int i=0;i<n;i++) {
            currRem=((currRem+a[i])%n+n)%n;
            res+=(remFreq.getOrDefault(currRem,0));
            remFreq.put(currRem,remFreq.getOrDefault(currRem,0)+1);
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