/**
 * Leetcode周赛No.200第三题 排布二进制网格的最少交换次数 显示英文描述
 * 给你一个 n x n 的二进制网格 grid，每一次操作中，你可以选择网格的 相邻两行 进行交换。
 * 一个符合要求的网格需要满足主对角线以上的格子全部都是 0 。
 * 请你返回使网格满足要求的最少操作次数，如果无法使网格符合要求，请你返回 -1 。
 * 主对角线指的是从 (1, 1) 到 (n, n) 的这些格子。
 * <p>
 * 【一个关键点：因为从上到下是从大到小的，所以不需要担心前面的占用了后面的格子，只需要向下找就可以了】
 * 从第一行开始从后往前遍历找连续的0，符合条件就跳过，不符合就向下找第一个符合的交换上来
 */
package week200;

public class P0003 {
    public static void main( String[] args ) {
        int[][] arr = new int[][]{{1 , 0 , 0} , {1 , 1 , 0} , {1 , 1 , 1}};
        System.out.println( new Solution( ).minSwaps( arr ) );
    }

    static class Solution {
        public int minSwaps( int[][] grid ) {
            int len = grid.length;
            int[] res = new int[len];
            int[] index = new int[len];
            for (int i = 0; i < len; i++) {
                int tmp = 0;
                for (int j = len - 1; j > -1; j--) {
                    if ( grid[i][j] == 0 ) tmp++;
                    else break;
                }
                res[i] = tmp;
            }
            int cnt = 0;
            for (int i = 0; i < len - 1; i++) {
                if ( res[i] > len - i - 1 )continue;
                int j = i;
                while(j < len && res[j] < len - i - 1)j++;
                if ( j==len )return -1;
                while(j!=i){
                    swap( res,j,j-1 );
                    cnt++;
                    j--;
                }
            }
            return cnt;
        }
        public void swap(int[] a, int i, int j){
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
