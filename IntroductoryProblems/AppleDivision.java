import java.util.*;

public class AppleDivision {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];

        for (int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        Solution solution=new Solution();
        solution.solve(nums,n);
    }
}

class Solution {
    public void solve(int[] nums,int n) {
        long firstGroup=0;
        long secondGroup=0;
        long[] minSum={Long.MAX_VALUE};

        helper(0,firstGroup,secondGroup,minSum,nums,n);
        System.out.println(minSum[0]);
    }

    public void helper(int pos,long firstGroup,long secondGroup,long[] minSum,int[] nums,int n) {
        if (pos==n) {
            minSum[0]=Math.min(minSum[0],Math.abs(firstGroup-secondGroup));
            return;
        }

        //to first group
        helper(pos+1,firstGroup+nums[pos],secondGroup,minSum,nums,n);

        //to second group
        helper(pos+1, firstGroup, secondGroup+nums[pos], minSum, nums,n);
    }
}
