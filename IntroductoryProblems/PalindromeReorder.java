import java.util.Scanner;

public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();

        Solution solution=new Solution();
        solution.solve(word);
    }
}

class Solution {
    public void solve(String s) {
        int n=s.length();
        int[] freq=new int[26];
        int oddFreqCnt=0;
        int oddFreqCharIndex=-1;

        for (int i=0;i<n;i++) {
            char ch=s.charAt(i);
            freq[ch-'A']++;
        }

        for (int i=0;i<26;i++) {
            if ((freq[i]&1)==1) {
                oddFreqCnt++;
                oddFreqCharIndex=i;
            }
        }

        if (oddFreqCnt>1) {
            System.out.println("NO SOLUTION");
            return;
        }

        StringBuilder firstHalf=new StringBuilder();
        for (int i=0;i<26;i++) {
            if (i==oddFreqCharIndex)
                continue;

            char ch=(char)(i+'A');

            for (int j=0;j<freq[i]/2;j++)
                firstHalf.append(ch);
        }

        StringBuilder secondHalf=new StringBuilder(firstHalf);
        secondHalf.reverse();

        if (oddFreqCharIndex!=-1) {
            char ch=(char)(oddFreqCharIndex+'A');
            for (int j=0;j<freq[oddFreqCharIndex];j++) {
                firstHalf.append(ch);
            }
        }

        StringBuilder res=firstHalf.append(secondHalf);
        System.out.println(res);
    }
}
