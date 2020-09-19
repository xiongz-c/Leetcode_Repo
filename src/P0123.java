/**
 P0123：买卖股票III
 题意：给出每天股价，只能买卖两次，求最大收益
 题解：动态规划dp【当前天数】【是否持股】【卖出过几次】 = 当前有多少钱

 */
class P0123{
    public static void main(String[] args) {
        int[] prices = new int[]{3,3,4,0,0,3,1,4};
        System.out.println( new Solution().maxProfit( prices) );
    }
    static class Solution{
        public int maxProfit(int[] prices) {
            if(prices.length==0)return 0;
            long[][][] dp = new long[prices.length][2][3];
            dp[0][0][0] = 0;
            dp[0][1][0] = -prices[0];

            dp[0][0][1] = Integer.MIN_VALUE;
            dp[0][0][2] = Integer.MIN_VALUE;

            dp[0][1][1] = Integer.MIN_VALUE;
            dp[0][1][2] = Integer.MIN_VALUE;

            for (int i = 1;i < prices.length;i++){
                //never sell and buy
                dp[i][0][0] = 0;
                //no shares, sell once:1.sell yesterday 2.sell today
                dp[i][0][1] = Math.max( dp[i-1][1][0] + prices[i],dp[i-1][0][1] );
                //no shares, sell twice:1.sell yesterday 2.sell today
                dp[i][0][2] = Math.max( dp[i-1][1][1] + prices[i],dp[i-1][0][2] );
                //have shares, never sell:1.buy yesterday 2.buy today
                dp[i][1][0] = Math.max( dp[i-1][0][0] - prices[i],dp[i-1][1][0] );
                //have shares, sell once:1.buy yesterday 2.buy today
                dp[i][1][1] = Math.max( dp[i-1][0][1] - prices[i],dp[i-1][1][1] );
                // have shares but sell twice, impossible
                dp[i][1][2] = -Integer.MAX_VALUE;
            }
            return (int)Math.max( Math.max( dp[prices.length-1][0][1],dp[prices.length-1][0][2] ),0);
        }
    }
}