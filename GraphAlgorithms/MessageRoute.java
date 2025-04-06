import java.io.*;
import java.util.*;

public class MessageRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        String[] nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);
        
        List<List<Integer>> adjList=new ArrayList<>();
        for (int i=0;i<=n;i++)
            adjList.add(new ArrayList<>());

        for (int i=0;i<m;i++) {
            String[] ab=br.readLine().split(" ");

            int a=Integer.parseInt(ab[0]);
            int b=Integer.parseInt(ab[1]);

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        // out.println("adj List: "+adjList);
        
        Solution solution=new Solution();
        solution.solve(adjList,n,out);

        out.close(); // Important to flush output
    }
}

class Pair {
    int dist;
    int node;

    Pair(int dist,int node) {
        this.dist=dist;
        this.node=node;
    }
}

class Solution {
    public void solve(List<List<Integer>> adjList,int n,PrintWriter out) {
        int[] dist=new int[n+1];
        int[] path=new int[n+1];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> (Integer.compare(a.dist, b.dist)));

        Arrays.fill(dist,(int)1e7);

        dist[1]=0;
        pq.add(new Pair(0, 1));

        while (!pq.isEmpty()) {
            Pair curr=pq.poll();
            int currDist=curr.dist;
            int currNode=curr.node;

            for (int ngbr: adjList.get(currNode)) {
                int ngbrDist=dist[ngbr];
                int ngbrNewDist=currDist+1;

                if (ngbrNewDist<ngbrDist) {
                    dist[ngbr]=ngbrNewDist;
                    path[ngbr]=currNode;
                    pq.add(new Pair(ngbrNewDist, ngbr));
                }
            }
        }

        if (dist[n]==(int)1e7) {
            out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder res=new StringBuilder();
        res.append(dist[n]+1).append("\n");
        List<Integer> pathToLast=new ArrayList<>();
        
        int lastNode=n;

        while (lastNode!=1) {
            pathToLast.add(lastNode);
            lastNode=path[lastNode];
        }
        pathToLast.add(lastNode);

        Collections.reverse(pathToLast);

        for (int node: pathToLast)
            res.append(node).append(" ");

        // out.println("dist: "+Arrays.toString(dist));
        // out.println("path: "+Arrays.toString(path));

        out.println(res);
    }
}