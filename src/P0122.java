/**
 * P0122: Best Time to Buy and Sell Stock II
 * 题意：给一个数组表示每天价格，可以选时间购入和卖出，但是同时只能持有一个商品，求收益最大值。
 * 算法标记：贪心
 * 做法：...不学算法也能做的题，20分钟不能AC就好好反思一下
 */

public class P0122 {
    public static void main( String[] args ) {
        int[] arr = new int[]{1,2,3,4,5};
        Solution solution = new Solution();
        System.out.println( solution.maxProfit( arr ) );
    }

    static class Solution {
        public int maxProfit( int[] prices ) {
            int now = -1, sum = 0;
            for (int i = 0; i < prices.length; i++) {
                if ( now == -1 ) {
                    now = prices[i];
                    continue;
                }
                if ( now > prices[i] ) {
                    now = prices[i];
                    continue;
                }
                if ( i == prices.length - 1 ) {
                    if ( prices[i] >= now ) {
                        sum += prices[i] - now;
                    }
                    break;
                }
                if(prices[i+1] <= prices[i]){
                    sum += prices[i] - now;
                    now = -1;
                }
            }
            return sum;
        }
    }
}
