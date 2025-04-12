import java.io.*;
import java.util.*;

public class Playlist {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[] k=new int[n];
        
        for (int i=0;i<n;i++)
            k[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(k,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] k,int n,PrintWriter out) {
        Map<Integer,Integer> map=new HashMap<>();
        int left=0;
        int right=0;
        int maxLen=0;

        while (right<n) {
            if (map.containsKey(k[right]))
                left=Math.max(left,map.get(k[right])+1);

            int currLen=right-left+1;
            maxLen=Math.max(maxLen,currLen);

            map.put(k[right],right);
            right++;
        }

        out.println(maxLen);
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