// package CSESSolutionsJava.StringAlgorithms;//uncomment this line to run the code in local
import java.util.*;

public class FindingBorders {
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

        long mod=(long)1e9+7;
        long p1=31;
        long p2=37;
        
        long[] power1=new long[n];
        long[] power2=new long[n];

        power1[0]=power2[0]=1;

        for (int i=1;i<n;i++) {
            power1[i]=(power1[i-1]*p1)%mod;
            power2[i]=(power2[i-1]*p2)%mod;
        }

        long prefixHash1=0;
        long prefixHash2=0;
        long suffixHash1=0;
        long suffixHash2=0;

        for (int i=0;i<n-1;i++) {
            int leftVal=s.charAt(i)-'a'+1;
            int rightVal=s.charAt(n-1-i)-'a'+1;
            
            prefixHash1=(prefixHash1+leftVal*power1[i])%mod;
            suffixHash1=(suffixHash1*p1+rightVal)%mod;

            prefixHash2=(prefixHash2+leftVal*power2[i])%mod;
            suffixHash2=(suffixHash2*p2+rightVal)%mod;

            if ((prefixHash1==suffixHash1) && (prefixHash2==suffixHash2))
                res.append(i+1).append(" ");
        }

        System.out.println(res);
    }
}
