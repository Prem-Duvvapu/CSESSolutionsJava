import java.io.*;
import java.util.*;

public class DynamicRangeSumQueries {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int q=fr.nextInt();
        long[] x=new long[n];

        for (int i=0;i<n;i++) {
            x[i]=fr.nextLong();
        }

        Solution solution=new Solution();
        solution.solve(x,n,q,fr,out);

        out.close();
    }
}

class Solution {
    public void solve(long[] x,int n,int q,FastReader fr,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        SegmentTree st=new SegmentTree(n);
        st.build(0,0,n-1,x,n);

        for (int i=0;i<q;i++) {
            int type=fr.nextInt();

            if (type==1) {
                int k=fr.nextInt();
                int u=fr.nextInt();

                st.update(0,0,n-1,k-1,u);
            } else {
                int a=fr.nextInt();
                int b=fr.nextInt();

                long currRangeSum=st.query(0, 0, n-1, a-1, b-1);
                res.append(currRangeSum).append("\n");
            }

        }

        out.println(res);
    }
}

class SegmentTree {
    long[] seg;

    public SegmentTree(int n) {
        seg=new long[4*n];
    }

    public void build(int ind,int low,int high,long[] x,int n) {
        if (low==high) {
            seg[ind]=x[low];
            return;
        }

        int mid=low+(high-low)/2;
        build(2*ind+1,low,mid,x,n);
        build(2*ind+2,mid+1,high,x,n);

        seg[ind]=seg[2*ind+1]+seg[2*ind+2]; // leftSum+rightSum
    }

    public void update(int ind,int low,int high,int pos,int val) {
        if (low==high) {
            seg[ind]=val;
            return;
        }

        int mid=low+(high-low)/2;
        if (pos<=mid)
            update(2*ind+1,low,mid,pos,val);
        else
            update(2*ind+2,mid+1,high,pos,val);

        seg[ind]=seg[2*ind+1]+seg[2*ind+2];
    }

    public long query(int ind,int low,int high,int l,int r) {
        //no overlap
        if (r<low || l>high)
            return 0;

        //complete overlap
        if (low>=l && high<=r)
            return seg[ind];

        //partial overlap
        int mid=low+(high-low)/2;
        long leftSum=query(2*ind+1,low,mid,l,r);
        long rightSum=query(2*ind+2,mid+1,high,l,r);

        return (leftSum+rightSum);
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