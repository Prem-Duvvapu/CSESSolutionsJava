import java.io.*;
import java.util.*;

public class NearestSmallerValues {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++)
            x[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] x,int n,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        Stack<Integer> stack=new Stack<>();

        for (int i=0;i<n;i++) {
            while (!stack.isEmpty() && x[stack.peek()]>=x[i])
                stack.pop();

            if (stack.isEmpty())
                res.append(0);
            else
                res.append(stack.peek()+1);
            res.append(" ");

            stack.push(i);
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