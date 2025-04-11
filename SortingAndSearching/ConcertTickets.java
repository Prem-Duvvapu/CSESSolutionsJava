import java.io.*;
import java.util.*;

public class ConcertTickets {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);
 
        int n=fr.nextInt();
        int m=fr.nextInt();
        int[] h=new int[n];
        int[] t=new int[m];
 
        for (int i=0;i<n;i++)
            h[i]=fr.nextInt();
 
        for (int j=0;j<m;j++)
            t[j]=fr.nextInt();
 
        Solution solution=new Solution();
        solution.solve(h,t,n,m,out);
 
        out.close();
    }
}
 
class Solution {
    public void solve(int[] h,int[] t,int n,int m,PrintWriter out) {
        int[] res=new int[m];
        TreeMap<Integer,Integer> map=new TreeMap<>();
 
        for (int i=0;i<n;i++)
            map.put(h[i],map.getOrDefault(h[i], 0)+1);
 
 
        for (int i=0;i<m;i++) {
            Integer price=map.floorKey(t[i]);
 
            if (price==null) {
                res[i]=-1;
            } else {
                res[i]=price;
                if (map.get(price)==1)
                    map.remove(price);
                else
                    map.put(price,map.get(price)-1);
            }
        }
 
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<m;i++)
            sb.append(res[i]).append("\n");
 
        out.println(sb);
    }
 
    public int upperBound(List<Integer> list,int val) {
        int low=0;
        int high=list.size()-1;
        int res=list.size();
 
        while (low<=high) {
            int mid=low+(high-low)/2;
 
            if (list.get(mid)>val) {
                res=mid;
                high=mid-1;
            } else  {
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
