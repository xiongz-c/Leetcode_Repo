/**
 * P0221: Maximal Square
 * 题意：找到一个矩阵里由1构成的最大的矩阵，返回面积
 * 做法：中等难度的dp题。每一个点的dp值由左/左上/上三个点转移，转移方程是这三个点的最小值+1
 * 每次dp完之后更新边的最大值max（max，dp【i】【j】）
 * 因为只考虑相邻两行，可以用滚动数组降低空间复杂度
 */
public class P0221 {
    public static void main( String[] args ) {
        char[][] arr =new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution s = new Solution();
        System.out.println( s.maximalSquare( arr ) );
    }
    static class Solution{
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            if(m == 0)return 0;
            int n = matrix[0].length;
            int[][] dp = new int[2][n];
            int ans = -1;
            int now = 0;
            for (int i=0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if(i == 0 || j == 0) dp[now][j] = matrix[i][j] - '0';//处理边界
                    else{
                        if(matrix[i][j] == '0'){//中断了
                            dp[now][j] = 0;
                        }else{
                            dp[now][j] = Math.min( Math.min( dp[now^1][j],dp[now^1][j-1] ), dp[now][j-1] )+1;
                        }
                    }
                    ans = Math.max( ans,dp[now][j] );
                }
                now ^= 1;
            }
            return ans*ans;
        }
    }
}
