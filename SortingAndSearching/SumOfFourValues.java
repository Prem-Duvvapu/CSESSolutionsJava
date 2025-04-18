import java.io.*;
import java.util.*;

public class SumOfFourValues {
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
        int[][] sortedArr=new int[n][2];
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++) {
            sortedArr[i][0]=a[i];
            sortedArr[i][1]=i;
        }

        Arrays.sort(sortedArr,(a1,a2)->Integer.compare(a1[0],a2[0]));    

        for (int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int currSum=sortedArr[i][0]+sortedArr[j][0];
                int low=j+1;
                int high=n-1;

                while (low<high) {
                    currSum+=(sortedArr[low][0]+sortedArr[high][0]);

                    if (currSum==x) {
                        res.append(sortedArr[i][1]+1).append(" ").append(sortedArr[j][1]+1).append(" ").append(sortedArr[low][1]+1).append(" ").append(sortedArr[high][1]+1);
                        out.print(res);
                        return;
                    } else if (currSum<x) {
                        currSum-=(sortedArr[low][0]+sortedArr[high][0]);
                        low++;
                    } else {
                        currSum-=(sortedArr[low][0]+sortedArr[high][0]);
                        high--;
                    }
                }
            }
        }

        res.append("IMPOSSIBLE");
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