/**
 * P0200:Number of Islands
 * 题意：在二维数组里找(x最大的岛屿（连续的1）),说错了。。是找岛屿个数，连深度都不需要统计了
 * 做法：DFS/BFS。感谢智慧的沈老师，好像学java的时候就做过了
 */

public class P0200 {
    public static void main( String[] args ) {
        char[][] arr = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution s = new Solution();
        System.out.println( "ans : " + s.numIslands( arr ) );
    }

    static class Solution{

        //经典dfs
        public void dfs( char[][] grid , boolean[][] vis , int i, int j){
            if(vis[i][j])return;
            vis[i][j] = true;
            if(i > 0 && grid[i-1][j] == '1')dfs(grid,vis,i-1,j);
            if(i < grid.length-1 && grid[i+1][j] == '1')dfs(grid,vis,i+1,j);
            if(j > 0 && grid[i][j-1] == '1')dfs(grid,vis,i,j-1);
            if(j < grid[0].length-1 && grid[i][j+1] == '1')dfs(grid,vis,i,j+1);
        }

        public int numIslands(char[][] grid) {
            int ans = 0;
            int m = grid.length;
            if(m == 0)return 0;
            int n = grid[0].length;
            boolean[][] vis = new boolean[m][n];

            for (int i = 0;i < m;i++){
                for (int j = 0;j < n;j++){
                    if(grid[i][j] == '1'){//是岛屿的一部分
                        if(!vis[i][j]) {//是没走过的岛屿
                            ans++;
                            dfs( grid,vis,i,j );
                        }
                    }
                }
            }
            return ans;
        }
    }
}
