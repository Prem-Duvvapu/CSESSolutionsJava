import java.util.*;

public class GrayCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        Solution solution=new Solution();
        List<StringBuilder> list=solution.solve(n,n);

        StringBuilder res=new StringBuilder();
        for (int i=0;i<list.size()-1;i++) {
            res.append(list.get(i)).append("\n");
        }
        res.append(list.get(list.size()-1));

        System.out.println(res);
    }
}

class Solution {
    public List<StringBuilder> solve(int curr,int n) {
        if (curr==1) {
            List<StringBuilder> temp=new ArrayList<>();
            StringBuilder first=new StringBuilder();
            StringBuilder second;

            for (int i=0;i<n;i++)
                first.append("0");

            second=new StringBuilder(first);
            second.setCharAt(n-1,'1');

            temp.add(first);
            temp.add(second);

            return temp;
        }

        List<StringBuilder> prevList=solve(curr-1,n);
        List<StringBuilder> res=new ArrayList<>(prevList);

        for (int i=prevList.size()-1;i>=0;i--) {
            StringBuilder currString=new StringBuilder(prevList.get(i));
            currString.setCharAt(n-curr,'1');
            res.add(currString);
        }

        return res;
    }
}
