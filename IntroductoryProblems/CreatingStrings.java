import java.util.*;

public class CreatingStrings {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String word=sc.nextLine();

        Solution solution=new Solution();
        solution.solve(word);
    }
}

class Solution {
    public void solve(String word) {
        int n=word.length();
        StringBuilder res=new StringBuilder();
        StringBuilder curr=new StringBuilder();
        boolean[] visited=new boolean[n];
        char[] charArray=word.toCharArray();
        int[] cnt=new int[1];

        Arrays.sort(charArray);

        helper(curr,visited,res,cnt,charArray,n);

        System.out.println(cnt[0]);
        System.out.println(res);
    }

    public void helper(StringBuilder curr,boolean[] visited,StringBuilder res,int[] cnt,char[] charArray,int n) {
        if (curr.length()==n) {
            res.append(new StringBuilder(curr)).append("\n");
            cnt[0]++;
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i] || (i>0 && !visited[i-1] && charArray[i]==charArray[i-1]))
                continue;

            visited[i]=true;
            curr.append(charArray[i]);
            helper(curr, visited, res, cnt, charArray, n);
            visited[i]=false;
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
