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
        int res=helper(0,board);
        System.out.println(res);
    }

    public int helper(int col,char[][] board) {
        if (col==board.length) {
            return 1;
        }

        int cnt=0;

        for (int row=0;row<board.length;row++) {
            if (board[row][col]=='.' && isValid(row,col,board)) {
                board[row][col]='Q';
                cnt+=helper(col+1,board);
                board[row][col]='.';
            }
        }

        return cnt;
    }

    public boolean isValid(int row,int col,char[][] board) {
        //left side of current row
        for (int j=0;j<col;j++)
            if (board[row][j]=='Q')
                return false;

        //left upper diagonal of current cell
        int i=row-1;
        int j=col-1;

        while (i>=0 && j>=0) {
            if (board[i][j]=='Q')
                return false;

            i--;
            j--;
        }

        //left lower diagonal of current cell
        i=row+1;
        j=col-1;

        while (i<board.length && j>=0) {
            if (board[i][j]=='Q')
                return false;

            i++;
            j--;
        }

        return true;
    }
}