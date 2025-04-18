import java.io.*;
import java.util.*;

public class ReadingBooks {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] t=new int[n];

        for (int i=0;i<n;i++)
            t[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(t,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] t,int n,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        Arrays.sort(t);
        long smallerTimesSum=0;

        for (int i=0;i<n-1;i++)
            smallerTimesSum+=t[i];

        if (smallerTimesSum<(long)t[n-1])
            res.append(2*t[n-1]);
        else
            res.append(smallerTimesSum+t[n-1]);

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