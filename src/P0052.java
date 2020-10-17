class P0052{
    static class Solution {
        int res = 0;
        public int totalNQueens( int n) {
            solve( new int[n],n,0,0,0,0 );
            return res;
        }

        public void solve(int[] queens,int n,int row,int columns,int diagonals1,int diagonals2){
            if(row == n){
                res++;
                return;
            }
            int availableLocation = ((1<<n)-1) & (~(columns|diagonals1|diagonals2));
            diagonals1 <<= 1;
            diagonals2 >>= 1;
            while (availableLocation!=0){// have availableLocation
                int position = availableLocation & (-1 * availableLocation);
                int columnNum = Integer.bitCount( position - 1 );
                queens[row] = columnNum;
                availableLocation = availableLocation & (availableLocation-1);
                solve( queens,n,row+1,columns|position,diagonals1|position << 1,diagonals2|position >> 1 );
            }

        }
    }
}