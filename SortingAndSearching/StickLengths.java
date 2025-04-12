import java.io.*;
import java.util.*;

public class StickLengths {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] p=new int[n];

        for (int i=0;i<n;i++)
            p[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(p,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] p,int n,PrintWriter out) {
        Arrays.sort(p);
        int median=p[n/2];
        long res=0;

        for (int i=0;i<n;i++)
            res+=Math.abs(p[i]-median);

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