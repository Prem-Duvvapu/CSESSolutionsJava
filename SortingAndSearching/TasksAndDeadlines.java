import java.io.*;
import java.util.*;

public class TasksAndDeadlines {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[][] arr=new int[n][2];

        for (int i=0;i<n;i++) {
            arr[i][0]=fr.nextInt();
            arr[i][1]=fr.nextInt();
        }

        Solution solution=new Solution();
        solution.solve(arr,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[][] arr,int n,PrintWriter out) {
        Arrays.sort(arr,(x,y)->Integer.compare(x[0],y[0]));
        long currFinishingTime=0;
        long res=0;

        for (int i=0;i<n;i++) {
            currFinishingTime+=arr[i][0];
            res+=(arr[i][1]-currFinishingTime);
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