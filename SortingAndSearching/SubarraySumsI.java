import java.io.*;
import java.util.*;

public class SubarraySumsI {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] a=new int[n];

        for (int i=0;i<n;i++)
            a[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,n,x,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] a,int n,int x,PrintWriter out) {
        int res=helper(a,x,n)-helper(a,x-1,n);
        out.print(res);
    }

    public int helper(int[] a,int k,int n) {
        int cnt=0;
        int currSum=0;
        int left=0;
        int right=0;

        while (right<n) {
            currSum+=a[right];

            while (currSum>k) {
                currSum-=a[left];
                left++;
            }

            cnt+=(right-left+1);
            right++;
        }

        return cnt;
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