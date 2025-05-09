import java.io.*;
import java.util.*;

public class ShortestRoutesI {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int m=fr.nextInt();

        List<Pair>[] adjList=new ArrayList[n+1];

        for (int i=0;i<n+1;i++)
            adjList[i]=new ArrayList<>();

        for (int i=0;i<m;i++) {
            int a=fr.nextInt();;
            int b=fr.nextInt();
            int c=fr.nextInt();

            adjList[a].add(new Pair(b,c));
        }

        Solution solution=new Solution();
        solution.solve(adjList,n,m);

        out.println(solution.sb);

        out.close();
    }
}

class Pair {
    int node;
    long dist;

    public Pair(int node,long dist) {
        this.node=node;
        this.dist=dist;
    }
}


class Solution {
    static final int MOD=1_000_000_000 + 7;
    public StringBuilder sb=new StringBuilder();
    
    //write the logic here
    public void solve(List<Pair>[] adjList,int n,int m) {
        long[] res=new long[n+1];
        PriorityQueue<Pair> minHeap=new PriorityQueue<>((x,y) -> Long.compare(x.dist,y.dist));

        Arrays.fill(res,Long.MAX_VALUE);
        res[1]=0L;
        minHeap.add(new Pair(1,0L));

        while (!minHeap.isEmpty()) {
            Pair top=minHeap.poll();
            int currSrc=top.node;
            long currDist=top.dist;

            if (currDist > res[currSrc])
                continue;

            for (Pair ngbr: adjList[currSrc]) {
                if (currDist+ngbr.dist < res[ngbr.node]) {
                    res[ngbr.node]=currDist+ngbr.dist;
                    minHeap.add(new Pair(ngbr.node,res[ngbr.node]));
                }
            }
        }

        StringJoiner sj = new StringJoiner(" ");
        for (int i = 1; i <= n; i++)
            sj.add(Long.toString(res[i]));

        sb.append(sj.toString());
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