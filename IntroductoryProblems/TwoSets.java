import java.util.Scanner;

public class TwoSets {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Solution solution=new Solution();
        solution.solve(n);
    }
}

class Solution {
    public void solve(int n) {
        long sum=((long)n*(n+1))/2;

        if (sum%2==1) {
            System.out.println("NO");
            return;
        }
        
        long half=sum/2;
        int i=n;
        StringBuilder set1=new StringBuilder();
        StringBuilder set2=new StringBuilder();
        int cnt1=0;

        while (i>0 && half>0) {
            if (i<=half) {
                set1.append(i).append(" ");
                half-=i;
                cnt1++;
            } else {
                set2.append(i).append(" ");
            }

            i--;
        }

        if (half>0) {
            System.out.println("NO");
            return;
        }

        while (i>0) {
            set2.append(i).append(" ");
            i--;
        }

        System.out.println("YES");
        System.out.println(cnt1);
        System.out.println(set1);
        System.out.println(n-cnt1);
        System.out.println(set2);
    }
}
