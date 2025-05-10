import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class RoundTrip {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int m=fr.nextInt();

        //undirected graph
        List<Integer>[] adjList=new ArrayList[n+1];

        for (int i=0;i<n+1;i++)
            adjList[i]=new ArrayList<>();

        for (int i=0;i<m;i++) {
            int u=fr.nextInt();
            int v=fr.nextInt();

            adjList[u].add(v);
            adjList[v].add(u);
        }

        Solution solution=new Solution();
        solution.solve(adjList,n);
        out.println(solution.sb);

        out.close();
    }
}

class Solution {
    static final int MOD=1_000_000_000 + 7;
    public StringBuilder sb=new StringBuilder();
    
    //write the logic here
    public void solve(List<Integer>[] adjList,int n) {
        StringJoiner sj=new StringJoiner(" ");
        boolean[] visited=new boolean[n+1];
        int[] child=new int[n+1];
        int cycleStart=-1;

        for (int i=1;i<n+1;i++) {
            if (!visited[i]) {
                cycleStart=isCycle(i,-1,visited,child,adjList,n); {
                    if (cycleStart!=-1)
                        break;
                }
            }
        }

        if (cycleStart==-1) {
            sb.append("IMPOSSIBLE");
            return;
        }

        int curr=cycleStart;
        sj.add(Integer.toString(curr));
        curr=child[curr];
        int cnt=1;

        while (curr!=cycleStart) {
            sj.add(Integer.toString(curr));
            curr=child[curr];
            cnt++;
        }

        sj.add(Integer.toString(curr));
        cnt++;
        sb.append(cnt).append("\n");
        sb.append(sj.toString());
    }

    public int isCycle(int curr,int parent,boolean[] visited,int[] child,List<Integer>[] adjList,int n) {
        visited[curr]=true;

        for (int ngbr: adjList[curr]) {
            if (!visited[ngbr]) {
                child[curr]=ngbr;
                int cycleStart=isCycle(ngbr, curr, visited, child,adjList, n);
                if (cycleStart!=-1)
                    return cycleStart;
            } else if (ngbr!=parent) {
                child[curr]=ngbr;
                return ngbr;
            }
        }

        return -1;
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