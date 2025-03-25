// package CSESSolutionsJava.StringAlgorithms;//uncomment this line to run the code in local
import java.util.*;

public class StringMatching {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.next();
        String pattern=sc.next();

        Solution solution=new Solution();
        int res=solution.solve(word,pattern);

        System.out.println(res);
    }
}

//KMP algorithm or Longest Prefix Suffix(LPS) algorithm
class Solution {
    public int solve(String word,String pattern) {
        int n=word.length();
        int m=pattern.length();
        int cnt=0;

        int[] lps=new int[m];
        lps[0]=0;
        int currLength=0;
        int j=1; //to iterate over pattern

        while (j<m) {
            if (pattern.charAt(j)==pattern.charAt(currLength)) {
                currLength++;
                lps[j]=currLength;
                j++;
            } else {
                if (currLength==0) {
                    lps[j]=0;
                    j++;
                } else {
                    currLength--;
                    currLength=lps[currLength];
                }
            }
        }

        int i=0; //to iterate over word
        j=0;
        while (i<n && j<m) {
            if (word.charAt(i)==pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j==0)
                    i++;
                else
                    j=lps[j-1];
            }

            if (j==m) {
                cnt++;
                j=lps[m-1];
            }
        }

        return cnt;
    }
}
