import java.io.*;
import java.util.*;

public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n = fr.nextInt();
        int x = fr.nextInt();

        int[] p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = fr.nextInt();

        Solution solution=new Solution();
        solution.solve(p, n, x, out);

        out.flush();
    }
}

class Solution {
    public void solve(int[] p, int n, int x, PrintWriter out) throws IOException {
        Arrays.sort(p);
        int res = 0;
        int left = 0, right = n - 1;

        while (left <= right) {
            if (p[left] + p[right] <= x) {
                left++;
                right--;
            } else {
                right--;
            }
            res++;
        }

        out.println(res);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
        br = new BufferedReader(
            new InputStreamReader(System.in));
    }

    String next()
    {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e) {
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
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
