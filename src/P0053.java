/**
 * P0053: Maximum Subarray
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
