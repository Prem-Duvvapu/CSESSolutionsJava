import java.io.*;
import java.util.*;

public class SumOfThreeValues {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int x=fr.nextInt();
        int[] a=new int[n];

        for (int i=0;i<n;i++)
            a[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] a,int x,int n,PrintWriter out) {
        int[][] arr=new int[n][2];
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++) {
            arr[i][0]=a[i];
            arr[i][1]=i;
        }

        Arrays.sort(arr, (p,q) -> Integer.compare(p[0],q[0]));

        for (int i=0;i<n-2;i++) {
            int low=i+1;
            int high=n-1;
            
            while (low<high) {
                int currSum=arr[i][0]+arr[low][0]+arr[high][0];

                if (currSum==x) {
                    res.append(arr[i][1]+1).append(" ").append(arr[low][1]+1).append(" ").append(arr[high][1]+1);
                    out.print(res);
                    return;
                } else if (currSum<x) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        out.print("IMPOSSIBLE");
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