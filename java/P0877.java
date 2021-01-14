/**
 * P0087:石子游戏
 * 题意：给一个整数数组，每次可以从两头中任意一头拿一个整数，假设两个人都是使用最优的策略，求拿完之后谁是胜者
 * 拿到整数较多的一方胜利，石头数量是奇数，没有平局。
 * 先手胜利返回true，后手胜利返回false
 * 题解：minimax算法
 * 注：此题的限制条件-数组长度为偶数且总石子是奇数可以先手必胜...
 * 
 */
class P0877{
    public static void main(String[] args) {
        
    }
    static class Solution {
        public boolean stoneGame(int[] piles) {
            int length = piles.length;
            int[][] dp = new int[length][length];
            for (int i = 0; i < length; i++) {
                dp[i][i] = piles[i];
            }
            for (int i = length - 2; i >= 0; i--) {
                for (int j = i + 1; j < length; j++) {
                    dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
                }
            }
            return dp[0][length - 1] > 0;
        }
    }
}