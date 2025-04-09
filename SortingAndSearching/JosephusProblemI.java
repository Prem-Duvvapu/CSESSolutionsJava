
import java.io.*;
import java.util.*;

public class JosephusProblemI {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(n,out);

        out.close();
    }
}

class Solution {
    public void solve(int n,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        Queue<Integer> q=new LinkedList<>();
        boolean canRemove=false;

        for (int i=1;i<=n;i++)
            q.add(i);

        while (!q.isEmpty()) {
            int curr=q.poll();

            if (canRemove)
                res.append(curr).append(" ");
            else
                q.add(curr);

            canRemove=!canRemove;
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