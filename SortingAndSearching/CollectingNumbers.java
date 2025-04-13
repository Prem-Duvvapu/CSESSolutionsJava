import java.io.*;
import java.util.*;

public class CollectingNumbers {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] arr=new int[n];

        for (int i=0;i<n;i++)
            arr[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(arr,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] arr,int n,PrintWriter out) {
        int[] elePos=new int[n+1];
        int rounds=0;
        int i=1;

        for (int j=0;j<n;j++)
            elePos[arr[j]]=j;

        while (i<=n) {
            rounds++;
            if (i==n)
                break;

            while (i<n && elePos[i+1]>elePos[i]) {
                i++;
            }

            i++;
        }

        out.println(rounds);
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