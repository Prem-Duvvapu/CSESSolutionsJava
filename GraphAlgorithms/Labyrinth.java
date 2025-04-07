import java.io.*;
import java.util.*;

public class Labyrinth {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        String[] nm=br.readLine().split(" ");
        int n=Integer.parseInt(nm[0]);
        int m=Integer.parseInt(nm[1]);

        char[][] grid=new char[n][m];
        for (int i=0;i<n;i++)   
            grid[i]=br.readLine().toCharArray();

        Solution solution=new Solution();
        solution.solve(grid,n,m,out);

        out.close();
    }
}

class Solution {
    public void solve(char[][] grid,int n,int m,PrintWriter out) {
        Queue<Integer> q=new LinkedList<>();
        int src=-1;
        int dest=-1;
        int[] path=new int[n*m];
        boolean[] visited=new boolean[n*m];

        int[] dRow={-1,0,1,0};
        int[] dCol={0,1,0,-1};

        for (int i=0;i<n*m;i++)
            path[i]=i;

        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if (grid[i][j]=='A')
                    src=m*i+j;

                if (grid[i][j]=='B')
                    dest=m*i+j;

                if (src!=-1 && dest!=-1)
                    break;
            }
        }

        q.add(src);
        visited[src]=true;

        while (!q.isEmpty()) {
            int currCell=q.poll();
            int currRow=currCell/m;
            int currCol=currCell%m;

            if (currCell==dest)
                break;

            for (int i=0;i<4;i++) {
                int newRow=currRow+dRow[i];
                int newCol=currCol+dCol[i];
                int newCell=m*newRow+newCol;

                if (newRow>=0 && newRow<n && newCol>=0 && newCol<m && newCell>=0 && newCell<n*m && grid[newRow][newCol]!='#' && !visited[newCell]) {
                    visited[newCell]=true;
                    path[newCell]=currCell;
                    q.add(newCell);
                }
            }
        }

        if (path[dest]==dest) {
            out.println("NO");
            return;
        }

        int curr=dest;
        StringBuilder shortPath=new StringBuilder();

        while (path[curr]!=curr) {
            int prev=path[curr];

            if (prev<curr) { //R or D
                if (prev==curr-1)
                    shortPath.append("R");
                else
                    shortPath.append("D");
            } else { //L or U
                if (prev==curr+1)
                    shortPath.append("L");
                else
                    shortPath.append("U");
            }

            curr=path[curr];
        }

        shortPath.reverse();
        StringBuilder res=new StringBuilder();
        res.append("YES").append("\n").append(shortPath.length()).append("\n").append(shortPath);

        out.println(res);
    }
}