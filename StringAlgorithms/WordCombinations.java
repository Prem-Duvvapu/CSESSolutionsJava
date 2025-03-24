// package CSESSolutionsJava.StringAlgorithms;//uncomment this line to run the code in local
import java.util.*;

class TrieNode {
    TrieNode[] arr;
    boolean endOfWord;

    TrieNode() {
        arr=new TrieNode[26];
        endOfWord=false;
    }
}

class Trie {
    TrieNode root;

    Trie() {
        root=new TrieNode();
    }

    public void insertWord(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.arr[ch-'a']==null)
                curr.arr[ch-'a']=new TrieNode();
            
            curr=curr.arr[ch-'a'];
        }

        curr.endOfWord=true;
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
            dp[i]=countWays(i,s,trie,dp);
        }

        return dp[0];
    }

    public static int countWays(int start,String s,Trie trie,int[] dp) {
        int ways=0;
        TrieNode currNode=trie.root;
        int mod=(int)1e9+7;

        for (int i=start;i<s.length();i++) {
            char ch=s.charAt(i);
            if (currNode.arr[ch-'a']==null)
                return ways;
            
            currNode=currNode.arr[ch-'a'];
            if (currNode.endOfWord)
                ways=(ways+dp[i+1])%mod;
        }

        return ways;
    }
}
