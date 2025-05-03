//This is the logic
//But java code is giving tle for some test cases
//So you can submit same logic in cpp(refer Projects.cpp)
import java.io.*;
import java.util.*;

public class Projects {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        //take input
        int n=fr.nextInt();
        int[][] arr=new int[n][3];

        for (int i=0;i<n;i++) {
            arr[i][0]=fr.nextInt();
            arr[i][1]=fr.nextInt();
            arr[i][2]=fr.nextInt();
        }

        Solution solution=new Solution();
        solution.solve(arr,n,out);

        out.close();
    }
}

class Pair {
    int index;
    int profit;
    
    public Pair(int index,int profit) {
        this.index=index;
        this.profit=profit;
    }
}

class Solution {
    static final int MOD=1_000_000_000 + 7;
    
    //write the logic here
    public void solve(int[][] arr,int n,PrintWriter out) {
        //unique start days
        Map<Integer,Integer> treeMap=new TreeMap<>();

        for (int[] a: arr) {
            treeMap.put(a[0],0);
            treeMap.put(a[1]+1,0);
        }

        int uniqueStartDaysCnt=0;
        for (Map.Entry<Integer,Integer> m: treeMap.entrySet())
            treeMap.put(m.getKey(),uniqueStartDaysCnt++);

            ArrayList<Pair>[] projectsByEndDay = new ArrayList[uniqueStartDaysCnt];
            for (int i = 0; i < uniqueStartDaysCnt; i++)
                projectsByEndDay[i] = new ArrayList<>();
            

        for (int i=0;i<n;i++) {
            int start=treeMap.get(arr[i][0]);
            int end=treeMap.get(arr[i][1]+1);
            projectsByEndDay[end].add(new Pair(start,arr[i][2]));
        }

        long[] dp=new long[uniqueStartDaysCnt];

        for (int i=1;i<uniqueStartDaysCnt;i++) {
            dp[i]=dp[i-1];

            for (Pair pair: projectsByEndDay[i])
                dp[i]=Math.max(dp[i],dp[pair.index]+pair.profit);
        }

        out.println(dp[uniqueStartDaysCnt-1]);
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