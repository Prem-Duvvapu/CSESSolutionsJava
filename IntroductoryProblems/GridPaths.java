import java.util.*;

public class GridPaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String path=sc.next();

        Solution solution=new Solution();
        solution.solve(path);
    }
}

class Solution {
    int[] dRow={-1,0,1,0};
    int[] dCol={0,1,0,-1};

    public void solve(String path) {
        int startRow=0;
        int startCol=0;
        int n=7;
        boolean[][] inPath=new boolean[n][n];
        int res=helper(0,startRow,startCol,inPath,path,n);
        System.out.println(res);
    }

    public int helper(int pos,int r,int c,boolean[][] inPath,String path,int n) {
        //out of bounds
        if (r<0 || r>=n || c<0 || c>=n)
            return 0;

        //vertical trap
        if ((r == 0 || inPath[r - 1][c]) && (r == n - 1 || inPath[r + 1][c]) && (c > 0 && !inPath[r][c - 1]) && (c < n - 1 && !inPath[r][c + 1]))
            return 0;
        
        //horizontal trap
        if ((c == 0 || inPath[r][c - 1]) && (c == n - 1 || inPath[r][c + 1]) && (r > 0 && !inPath[r - 1][c]) && (r < n - 1 && !inPath[r + 1][c]))
            return 0;

        //already in path
        if (inPath[r][c])
            return 0;

        //completed all the directions in the string path
        if (pos==path.length()) {
            if (r==6 && c==0)
                return 1;

            return 0;
        }

        //destination is reached early
        if (r==6 && c==0)
            return 0;

        inPath[r][c]=true;
        char ch=path.charAt(pos);

        int cnt=0;
        switch (ch) {
            case '?':
                for (int i=0;i<4;i++) {
                    int newRow=r+dRow[i];
                    int newCol=c+dCol[i];
                    
                    cnt+=helper(pos+1,newRow,newCol,inPath,path,n);
                }
                break;
            case 'U':
                cnt+=helper(pos+1,r-1,c,inPath,path,n);
                break;
            case 'D':
                cnt+=helper(pos+1,r+1,c,inPath,path,n);
                break;
            case 'L':
                cnt+=helper(pos+1,r,c-1,inPath,path,n);
                break;
            case 'R':
                cnt+=helper(pos+1,r,c+1,inPath,path,n);
                break;
            default:
                break;
        }

        inPath[r][c]=false;
        return cnt;
    }
}