import java.util.*;

public class MinimalRotation {
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
        String res=s;

        for (int i=1;i<n;i++) {
            String newString=s.substring(i,n)+s.substring(0,i);
            res=compareStrings(res,newString,n);
        }
        
        System.out.println(res);
    }

    public String compareStrings(String s1,String s2,int n) {
        for (int i=0;i<n;i++) {
            if (s1.charAt(i)<s2.charAt(i))
                return s1;
            else if (s2.charAt(i)<s1.charAt(i))
                return s2;
        }

        return s1;
    }
}
