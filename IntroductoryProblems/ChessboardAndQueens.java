import java.util.*;

public class ChessboardAndQueens {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[][] board=new char[8][8];

        for (int i=0;i<8;i++)
            board[i]=sc.nextLine().toCharArray();

        Solution solution=new Solution();
        solution.solve(board);
    }
}

class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        boolean[] rowCheck=new boolean[n];
        boolean[] topDiagonalCheck=new boolean[n*2];
        boolean[] downDiagonalCheck=new boolean[n*2];
        int res=helper(0,board,rowCheck,topDiagonalCheck,downDiagonalCheck,n);
        System.out.println(res);
    }

    public int helper(int col,char[][] board,boolean[] rowCheck,boolean[] topDiagonalCheck,boolean[] downDiagonalCheck,int n) {
        if (col==n)
            return 1;

        int cnt=0;

        for (int row=0;row<n;row++) {
            if (board[row][col]=='.' && isValid(row,col,board,rowCheck,topDiagonalCheck,downDiagonalCheck,n)) {
                board[row][col]='Q';
                rowCheck[row]=true;
                topDiagonalCheck[n+(row-col)]=true;
                downDiagonalCheck[row+col]=true;

                cnt+=helper(col+1,board,rowCheck,topDiagonalCheck,downDiagonalCheck,n);
                
                board[row][col]='.';
                rowCheck[row]=false;
                topDiagonalCheck[n+(row-col)]=false;
                downDiagonalCheck[row+col]=false;
            }
        }

        return cnt;
    }

    public boolean isValid(int row,int col,char[][] board,boolean[] rowCheck,boolean[] topDiagonalCheck,boolean[] downDiagonalCheck,int n) {
        //left side of current row
        boolean notValidRow=rowCheck[row];

        //left upper diagonal of current cell
        boolean notValidTopDiagonal=topDiagonalCheck[n+(row-col)];

        //left lower diagonal of current cell
        boolean notValidDownDiagonal=downDiagonalCheck[row+col];

        return !(notValidRow || notValidTopDiagonal || notValidDownDiagonal);
    }
}