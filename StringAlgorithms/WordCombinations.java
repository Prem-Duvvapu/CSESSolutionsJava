package CSESSolutionsJava.StringAlgorithms;
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

    public boolean isWordExists(String word) {
        TrieNode curr=root;

        for (char ch: word.toCharArray()) {
            if (curr.arr[ch-'a']==null)
                return false;

            curr=curr.arr[ch-'a'];
        }

        return curr.endOfWord==true;
    }
}

public class WordCombinations {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int k=sc.nextInt();
        String[] words=new String[k];

        for (int i=0;i<k;i++)
            words[i]=sc.nextLine();

        System.out.println(solve(s,k,words));
    }

    public static int solve(String s,int k,String[] words) {
        int n=s.length();
        Trie trie=new Trie();
        int[] dp=new int[n+1];

        for (String word: words)
            trie.insertWord(word);

        for (int i=n-1;i<n;i++) {
            for (int j=i;j<n;j++) {
                String prefix=s.substring(i,j+1);

                if (trie.isWordExists(prefix))
                    dp[i]+=dp[j+1];
            }
        }

        return dp[0];
    }
}
