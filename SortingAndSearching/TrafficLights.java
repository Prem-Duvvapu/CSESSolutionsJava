import java.io.*;
import java.util.*;

public class TrafficLights {
    public static void main(String[] args) {
        FastReader fr=new FastReader();
        PrintWriter out=new PrintWriter(System.out);

        int x=fr.nextInt();
        int n=fr.nextInt();
        int[] p=new int[n];

        for (int i=0;i<n;i++)
            p[i]=fr.nextInt();

        Solution solution=new Solution();
        solution.solve(p,x,n,out);

        out.close();
    }
}

class Solution {
    public void solve(int[] p,int x,int n,PrintWriter out) {
        StringBuilder res=new StringBuilder();
        TreeSet<Pair<Integer,Integer>> ranges=new TreeSet<>();
        TreeMap<Integer,Integer> rangeLengths=new TreeMap<>();

        ranges.add(new Pair<>(0,x));
        rangeLengths.put(x,1);

        for (int i=0;i<n;i++) {
            int curr=p[i];
            Pair<Integer,Integer> currPair=ranges.floor(new Pair<>(curr,curr));

            int currPairFirst=currPair.first;
            int currPairSecond=currPair.second;

            //ranges
            ranges.remove(currPair);
            ranges.add(new Pair<>(currPairFirst,curr));
            ranges.add(new Pair<>(curr,currPairSecond));

            //ranges length
            if (rangeLengths.get(currPairSecond-currPairFirst)==1)
                rangeLengths.remove(currPairSecond-currPairFirst);
            else
                rangeLengths.put(currPairSecond-currPairFirst,rangeLengths.get(currPairSecond-currPairFirst)-1);

            rangeLengths.put(curr-currPairFirst,rangeLengths.getOrDefault(curr-currPairFirst,0)+1);
            rangeLengths.put(currPairSecond-curr,rangeLengths.getOrDefault(currPairSecond-curr,0)+1);

            res.append(rangeLengths.lastKey()).append(" ");
        }

        out.print(res);
    }
}

class Pair<K extends Comparable<K>,V extends Comparable<V>> implements Comparable<Pair<K,V>> {
    K first;
    V second;

    public Pair(K first,V second) {
        this.first=first;
        this.second=second;
    }

    @Override
    public int compareTo(Pair<K,V> other) {
        int comp=this.first.compareTo(other.first);
        if (comp!=0)
            return comp;

        return this.second.compareTo(other.second);
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