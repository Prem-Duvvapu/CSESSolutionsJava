
import java.io.*;
import java.util.*;

public class SumOfTwoValues {
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
        int low=0;
        int high=n-1;
        int[][] arr=new int[n][2];

        for (int i=0;i<n;i++) {
            arr[i][0]=a[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr,(u,v)->(Integer.compare(u[0],v[0])));

        while (low<high) {
            int currSum=arr[low][0]+arr[high][0];

            if (currSum==x) {
                StringBuilder res=new StringBuilder();
                res.append(arr[low][1]+1).append(" ").append(arr[high][1]+1);
                out.println(res);
                return;
            } else if (currSum<x) {
                low++;
            } else {
                high--;
            }
        }

        out.println("IMPOSSIBLE");
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