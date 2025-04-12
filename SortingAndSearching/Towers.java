import java.io.*;
import java.util.*;

public class Towers {
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
        List<Integer> list=new ArrayList<>();
        list.add(k[0]);

        for (int i=1;i<n;i++) {
            upperBound(list,k[i]);
        }

        out.println(list.size());
    }

    public void upperBound(List<Integer> list,int val) {
        int pos=list.size();
        int low=0;
        int high=list.size()-1;

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (list.get(mid)>val) {
                pos=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        if (pos==list.size())
            list.add(val);
        else
            list.set(pos,val);
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