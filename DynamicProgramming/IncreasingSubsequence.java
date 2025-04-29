import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class IncreasingSubsequence {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int[] a=new int[n];

        for (int i=0;i<n;i++)
            a[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(a,n,out);

        out.close();
    }
}

class Solution {
    //write the logic here
    public void solve(int[] a,int n,PrintWriter out) {
        List<Integer> list=new ArrayList<>();

        for (int val: a) {
            if (list.isEmpty() || val>list.get(list.size()-1)) {
                list.add(val);
            } else {
                int index=upperBound(list,val);
                if (index<list.size())
                    list.set(index,val);
            }
        }

        int maxLen=list.size();
        out.println(maxLen);
    }

    public int upperBound(List<Integer> list,int target) {
        int low=0;
        int high=list.size()-1;
        int res=list.size();

        while (low<=high) {
            int mid=low+(high-low)/2;

            if (list.get(mid)>=target) {
                res=mid;
                high=mid-1;
            } else {
                low=mid+1;
            }
        }

        return res;
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