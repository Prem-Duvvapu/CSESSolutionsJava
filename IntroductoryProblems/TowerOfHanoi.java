import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Solution solution=new Solution();
        solution.solve(n);
    }
}

class Solution {
    public void solve(int n) {
        StringBuilder res=new StringBuilder();
        int src=1;
        int dest=3;
        int aux=2;
        int[] steps={0};

        helper(n,src,dest,aux,res,steps);
        System.out.println(steps[0]);
        System.out.println(res);
    }

    public void helper(int disk,int src,int dest,int aux,StringBuilder res,int[] steps) {
        if (disk==1) {
            res.append(src).append(" ").append(dest).append("\n");
            steps[0]++;
            return;
        }

        helper(disk-1,src,aux,dest,res,steps);
        res.append(src).append(" ").append(dest).append("\n");
        steps[0]++;
        helper(disk-1,aux,dest,src,res,steps);
    }
}
