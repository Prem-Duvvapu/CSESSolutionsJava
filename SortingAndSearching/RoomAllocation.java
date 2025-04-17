import java.io.*;
import java.util.*;

public class RoomAllocation {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int n=fr.nextInt();
        int[][] arr=new int[n][2];

        for (int i=0;i<n;i++) {
            arr[i][0]=fr.nextInt();
            arr[i][1]=fr.nextInt();
        }

        Solution solution=new Solution();
        solution.solve(arr,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[][] arr,int n,PrintWriter out) {
        int[][] sortedArr=new int[n][3];
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->Integer.compare(x[0],y[0]));
        int[] res=new int[n];
        StringBuilder sb=new StringBuilder();
        int totalRooms=0;

        for (int i=0;i<n;i++) {
            sortedArr[i][0]=arr[i][0];
            sortedArr[i][1]=arr[i][1];
            sortedArr[i][2]=i;
        }

        Arrays.sort(sortedArr,(x,y)->Integer.compare(x[0],y[0]));

        for (int i=0;i<n;i++) {
            int startDay=sortedArr[i][0];
            int endDay=sortedArr[i][1];
            int index=sortedArr[i][2];
            
            if (pq.isEmpty() || pq.peek()[0]>=startDay) {
                totalRooms+=1;
                res[index]=totalRooms;
                pq.add(new int[]{endDay,totalRooms});
            } else {
                int vacantRoom=pq.poll()[1];
                res[index]=vacantRoom;
                pq.add(new int[]{endDay, vacantRoom});
            }
        }

        sb.append(totalRooms).append("\n");
        for (int i=0;i<n;i++)
            sb.append(res[i]).append(" ");

        out.print(sb);
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