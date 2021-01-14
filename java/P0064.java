/**
 * P0064: Minimum Path Sum
 * 题意：给一个 m x n 的矩阵，每个点表示过去需要的步数，可以向右或者向下走，求最小路径
 * 做法：裸dp,注意m和n的顺序 不要数组越界
 */
public class P0064 {
    public static void main( String[] args ) {
        int[][] arr = new int[][]{{1,2,5},{3,2,1}};
        Solution solution = new Solution();
        System.out.println( solution.minPathSum( arr ) );
    }

    static class Solution{
        public int minPathSum(int[][] grid) {
            int m = grid.length,n = grid[0].length;
            int [][] ans = new int[m][n];
            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if(i == 0 && j == 0)ans[i][j] = grid[i][j];
                    else if(i == 0)ans[i][j] = grid[i][j] + ans[i][j-1];
                    else if(j == 0)ans[i][j] = grid[i][j] + ans[i-1][j];
                    else ans[i][j] = grid[i][j] + Math.min(ans[i-1][j],ans[i][j-1]);
                }
            }
            return ans[m-1][n-1];
        }
    }

}
