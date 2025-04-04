//gfg solution link : 

import java.util.Scanner;

public class DigitQueries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        StringBuilder res=new StringBuilder();
        Solution solution=new Solution();

        for (int i=0;i<q;i++) {
            long k=sc.nextLong();
            long digit=solution.solve(k);
            res.append(digit).append("\n");
        }

        System.out.println(res);
    }
}

class Solution {
    public long solve(long n) {
        //total number of numbers in the current interval
        long totalNumsInInterval=9;

        //no. of digits in each nubmer in the current interval
        long digits=1;

        while (n - digits*totalNumsInInterval > 0) {
            n-=digits * totalNumsInInterval;
            digits++;
            totalNumsInInterval*=10;
        }

        //the nuber containing the digit
        long numContainingDigit=power(10,digits-1)+(n-1)/digits;

        //the position of required digit in the numComtainingDigit
        long index=n%digits;

        if (index!=0)
            numContainingDigit=numContainingDigit/power(10,digits-index);

        long reqDigit=numContainingDigit%10;

        return reqDigit;
    }

    public long power(long a,long b) {
        if (b==0)
            return 1;

        long half=power(a,b/2);
        long res=half*half;

        if (b%2==1)
            res*=a;

        return res;
    }
}
