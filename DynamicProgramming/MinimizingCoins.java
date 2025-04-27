import java.io.*;
import java.util.*;

public class MinimizingCoins {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] c=new int[n];

        for (int i=0;i<n;i++)
            c[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(c,x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] c,int x,int n,PrintWriter out) {
        int[] prev=new int[x+1];
        int[] curr=new int[x+1];

        Arrays.fill(prev,(int)1e9);
        Arrays.fill(curr,(int)1e9);

        prev[0]=0;
        curr[0]=0;

        for (int target=c[0];target<=x;target+=c[0])
            prev[target]=1+prev[target-c[0]];

        for (int pos=1;pos<n;pos++) {
            for (int target=0;target<=x;target++) {
                int notPick=prev[target];
                int pick=(int)1e9;

                if (c[pos]<=target)
                    pick=1+curr[target-c[pos]];

                curr[target]=Math.min(pick,notPick);
            }

            for (int i=0;i<=x;i++)
                prev[i]=curr[i];
        }

        int res=(prev[x]>=(int)1e9) ? -1: prev[x];

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