/**
 * P0136:Single number
 * 题意：找出数列中唯一重复的数
 * 简单题
 */

public class P0136 {
    public static void main( String[] args ) {

    }
    static class Solution{
        public int singleNumber(int[] nums) {
            int ans= 0,len = nums.length;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }
}
