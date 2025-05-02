import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountingTowers {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int t=fr.nextInt();
        // int t=1;

        Solution solution=new Solution();

        while (t-- > 0) {
            //take input
            int n=fr.nextInt();

            //make call to execute the logic
            solution.solve(n);

            //new line after test case ans
            solution.res.append("\n");
        }

        out.println(solution.res);

        out.close();
    }
}

class Solution {
    public static final int INT_MOD=1_000_000_007;
    public static final long LONG_MOD=1_000_000_007L;
    public StringBuilder res=new StringBuilder();

    //write logic here and print the result
    public void solve(int n) {
        long[] prev=new long[2];
        long[] curr=new long[2];
        prev[0]=prev[1]=1;

        for (int i=1;i<n;i++) {
            curr[0]=(2*prev[0]+prev[1])%LONG_MOD;
            curr[1]=(4*prev[1]+prev[0])%LONG_MOD;

            prev[0]=curr[0];
            prev[1]=curr[1];
        }

        long numOfTowers=(prev[0]+prev[1])%LONG_MOD;
        res.append(numOfTowers);
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