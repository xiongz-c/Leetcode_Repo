/**
 * Leetcode周赛No.200第二题 找出数组游戏的赢家
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
 * 较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。
 * 当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * 返回赢得比赛的整数。
 * 题目数据 保证 游戏存在赢家。
 */
package week200;

public class P0002 {
    public static void main( String[] args ) {
        int[] arr = new int[]{904,797,25,566,643,134,400,41,835,528,165,43,282,225,857,594,149,703,431,899,144,941,840,16,230,403};
        int k = 13;
        Solution sol = new Solution();
        System.out.println( sol.getWinner( arr,k ) );
    }
        static class Solution {
            public int getWinner(int[] arr, int k) {
                int arr_size = arr.length;
                int[] maxArr = new int[arr_size];
                int max = Integer.MIN_VALUE;
                for(int i = 0;i < arr_size;i++){
                    if(max < arr[i])max=arr[i];
                    maxArr[i] = max;
                }
                if(k >= arr_size)return max;
                for (int i = k;i < arr_size;i++){
                    if(maxArr[i] == maxArr[i-k+1])return maxArr[i-k+1];
                }
                return max;
            }
        }
}
