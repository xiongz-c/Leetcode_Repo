/**
 * P0463: 岛屿的周长
 * 题意：找出格子数，然后找到他们的周长
 * 题解：遍历。。。
 */
class P0463{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int islandPerimeter(int[][] grid) {
            if (grid == null) return 0;
            int cnt = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 0)continue;
                    if(i-1 < 0){
                        cnt++;
                    }else if(grid[i-1][j]==0)cnt++;
                    if(j-1 < -0){
                        cnt++;
                    }else if(grid[i][j-1]==0)cnt++;
                    if(i+1 > grid.length-1){
                        cnt++;
                    }else if(grid[i+1][j]==0)cnt++;
                    if(j+1 > grid[0].length-1){
                        cnt++;
                    }else if(grid[i][j+1]==0)cnt++;
                }
            }
            return cnt;
        }
    }
}