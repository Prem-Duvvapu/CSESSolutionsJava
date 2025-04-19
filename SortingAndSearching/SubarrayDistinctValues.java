import java.io.*;
import java.util.*;

public class SubarrayDistinctValues {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int k=fr.nextInt();
        int[] x=new int[n];

        for (int i=0;i<n;i++)
            x[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(x,k,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] x,int k,int n,PrintWriter out) {
        long res=0;
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=0;

        while (right<n) {
            map.put(x[right],map.getOrDefault(x[right],0)+1);

            while (map.size()>k) {
                if (map.get(x[left])==1)
                    map.remove(x[left]);
                else
                    map.put(x[left],map.get(x[left])-1);

                left++;
            }

            res+=((long)right-left+1);
            right++;
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