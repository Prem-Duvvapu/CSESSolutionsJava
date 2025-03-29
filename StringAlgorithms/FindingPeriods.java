import java.util.*;

public class FindingPeriods {
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
        StringBuilder res=new StringBuilder();

        for (int i=0;i<n;i++) {
            int k=0;
            int j=i+1;
            for (;j<n;j++) {
                if (s.charAt(j)!=s.charAt(k))
                    break;
                k++;
            }

            if (j==n)
                res.append(i+1).append(" ");
        }

        System.out.println(res);
    }
}
