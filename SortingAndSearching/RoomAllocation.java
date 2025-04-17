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

class Pair implements Comparable<Pair> {
    int endDay;
    int roomNum;

    Pair(int endDay,int roomNum) {
        this.endDay=endDay;
        this.roomNum=roomNum;
    }

    @Override
    public int compareTo(Pair other) {
        if (this.endDay!=other.endDay)
            return Integer.compare(this.endDay, other.endDay);

        return Integer.compare(this.roomNum,other.roomNum);
    }
}

class Solution {
    public void solve(int[][] arr,int n,PrintWriter out) {
        int[][] sortedArr=new int[n][3];
        TreeSet<Pair> set=new TreeSet<>();
        int[] res=new int[n];
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<n;i++) {
            sortedArr[i][0]=arr[i][0];
            sortedArr[i][1]=arr[i][1];
            sortedArr[i][2]=i;
        }

        Arrays.sort(sortedArr,(x,y)->Integer.compare(x[1],y[1]));

        for (int i=0;i<n;i++) {
            int startDay=sortedArr[i][0];
            int endDay=sortedArr[i][1];
            int index=sortedArr[i][2];
            Pair curr=set.lower(new Pair(startDay,-1));
            int currRoomNum;

            if (curr==null) {
                currRoomNum=set.size()+1;
            } else {
                currRoomNum=curr.roomNum;
                set.remove(curr);
            }

            res[index]=currRoomNum;
            set.add(new Pair(endDay,currRoomNum));
        }

        sb.append(set.size()).append(" ");
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