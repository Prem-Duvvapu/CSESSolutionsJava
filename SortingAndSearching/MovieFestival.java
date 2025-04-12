import java.io.*;
import java.util.*;

public class MovieFestival {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[][] time=new int[n][2];

        for (int i=0;i<n;i++) {
            time[i][0]=fr.nextInt();
            time[i][1]=fr.nextInt();
        }

        Solution solution=new Solution();
        solution.solve(time,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[][] time,int n,PrintWriter out) {
        Arrays.sort(time,(x,y)->Integer.compare(x[1],y[1]));
        int res=1;
        int lastEndTime=time[0][1];

        for (int i=1;i<n;i++) {
            if (time[i][0]>=lastEndTime) {
                res++;
                lastEndTime=time[i][1];
            }
        }

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