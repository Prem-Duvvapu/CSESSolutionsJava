import java.io.*;
import java.util.*;

public class BuildingTeams {
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
            String[] edge=br.readLine().split(" ");
            int u=Integer.parseInt(edge[0]);
            int v=Integer.parseInt(edge[1]);

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // out.println("adjList: "+adjList);

        Solution solution=new Solution();
        solution.solve(adjList,n,out);
        out.close();
    }
}

class Solution {
    public void solve(List<List<Integer>> adjList,int n,PrintWriter out) {
        //two teams - team-1, team-2
        int[] team=new int[n+1];

        for (int i=1;i<=n;i++)
            if (team[i]==0)
                if (dfs(i,1,team,adjList,n,out))
                    return;

        StringBuilder res=new StringBuilder();
        for (int i=1;i<=n;i++)
            res.append(team[i]).append(" ");

        out.println(res);
    }

    public boolean dfs(int node,int currTeam,int[] team,List<List<Integer>> adjList,int n,PrintWriter out) {
        team[node]=currTeam;

        for (int ngbr: adjList.get(node)) {
            if (team[ngbr]==0) {
                int otherTeam=(currTeam==1) ? 2 : 1;
                if (dfs(ngbr,otherTeam,team,adjList,n,out))
                    return true;
            } else if (team[ngbr]==currTeam) {
                out.println("IMPOSSIBLE");
                return true;
            }
        }

        return false;
    }
}