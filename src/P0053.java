/**
 * P0053: Maximum Subarray
 * 简单题，直接扫一遍数组，如果发现某个sum的贡献已经是负值了，就抛弃掉前面的部分，只保留刚刚走到的数（一个数加上负值只会更小）
 * 每走一步都比较一下当前的sum和最大值的大小，取大值，最后输出结果即可
 */
public class P0053 {
    public static void main( String[] args ) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        P0053.Solution solution = new P0053.Solution();
        System.out.println( solution.maxSubArray( arr ));
    }

    static class Solution{
        public int maxSubArray(int[] nums) {
            int sum = nums[0];
            int ans = nums[0];
            int len = nums.length;
            for (int i = 1;i < len;i++){
                if(sum < 0)sum = nums[i];
                else sum += nums[i];
                ans = Math.max(ans,sum);
            }
            return ans;
        }
    }
}
