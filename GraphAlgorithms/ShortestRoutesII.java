//Getting TLE for 1 test cases
//So submitted the same login in CPP
//File name: ShortestRoutesII.cpp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class ShortestRoutesII {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take 
        int n=fr.nextInt();
        int m=fr.nextInt();
        int q=fr.nextInt();

        long[][] adjMatrix=new long[n+1][n+1];
        for (long[] arr: adjMatrix)
            Arrays.fill(arr,(long)1e12);

        for (int i=0;i<m;i++) {
            int a=fr.nextInt();
            int b=fr.nextInt();
            long c=fr.nextLong();

            adjMatrix[a][b]=Math.min(adjMatrix[a][b],c);
            adjMatrix[b][a]=Math.min(adjMatrix[b][a],c);
        }

        Solution solution=new Solution();
        solution.solve(adjMatrix,n,q,fr);

        out.println(solution.sb);
        out.close();
    }
}

class Solution {
    static final int MOD=1_000_000_000 + 7;
    public StringBuilder sb=new StringBuilder();

    
    //write the logic here
    public void solve(long[][] adjMatrix,int n,int q,FastReader fr) {
        final long INF = (long) 1e12;

        for (int i=1;i<n+1;i++)
            adjMatrix[i][i]=0L;

        //floyd warshall algorithm
        for (int k=1;k<n+1;k++) {
            for (int i=1;i<n+1;i++) {
                if (adjMatrix[i][k] == INF)
                    continue;

                for (int j=1;j<n+1;j++) {
                    if (adjMatrix[k][j] == INF)
                        continue;

                    long newDist = adjMatrix[i][k] + adjMatrix[k][j];
                    if (newDist < adjMatrix[i][j])
                        adjMatrix[i][j] = newDist;
                }
            }
        }

        StringJoiner joiner=new StringJoiner("\n");
        for (int i=0;i<q;i++) {
            int a=fr.nextInt();
            int b=fr.nextInt();

            joiner.add(adjMatrix[a][b] >= INF ? "-1" : Long.toString(adjMatrix[a][b]));
        }

        sb.append(joiner.toString());
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