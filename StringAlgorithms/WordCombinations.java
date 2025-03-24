// package CSESSolutionsJava.StringAlgorithms;//comment this line
import java.util.*;

class Trie {
    int[][] root;
    static int value=1;
    boolean[] endOfWord;

    Trie() {
        root=new int[(int)1e6+3][26];
        endOfWord=new boolean[(int)1e6+3];
    }

    public void insertWord(String word) {
        int currNode=0;

        for (char ch: word.toCharArray()) {
            if (root[currNode][ch-'a']==0) {
                root[currNode][ch-'a']=value;
                value++;
            }
            
            currNode=root[currNode][ch-'a'];
        }

        endOfWord[currNode]=true;
    }
}

public class WordCombinations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        String[] words=new String[k];

        for (int i=0;i<k;i++)
            words[i]=sc.next();

        System.out.println(solve(s,k,words));
    }

    public static int solve(String s,int k,String[] words) {
        int n=s.length();
        Trie trie=new Trie();
        int[] dp=new int[n+1];
        dp[n]=1;

        for (String word: words)
            trie.insertWord(word);

        for (int i=n-1;i>=0;i--) {
            dp[i]=countWays(i,s,trie.root,trie.endOfWord,dp);
        }

        return dp[0];
    }

    public static int countWays(int start,String s,int[][] root,boolean[] endOfWord,int[] dp) {
        int ways=0;
        int currNode=0;
        int mod=(int)1e9+7;

        for (int i=start;i<s.length();i++) {
            char ch=s.charAt(i);
            if (root[currNode][ch-'a']==0)
                return ways;
            
            currNode=root[currNode][ch-'a'];
            if (endOfWord[currNode])
                ways=(ways+dp[i+1])%mod;
        }

        return ways;
    }
}
