import java.util.Arrays;

/**
 * P0238:Product of Array Except Self
 * 做法：求前后缀乘积
 * 优化空间复杂度：不要开两个数组记录前后缀了，用一个temp记录当前就够了，然后来回做一次
 */

public class P0238 {
    public static void main( String[] args ) {
        int[] arr = new int[]{1,2,3,4};
        Solution s = new Solution();
        int[] ans = s.productExceptSelf( arr );
        for (int e:ans){
            System.out.print( e + ", " );
        }
    }

    static class Solution{
        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            for (int e:ans)e = 1;
            int temp =1;
            for (int i = 0;i <len;i++){
                if(i==0)ans[i] = 1;
                else ans[i] = ans[i-1]* nums[i-1];
            }
            for (int i = len-2;i > -1;i--){
                temp *= nums[i+1];
                ans[i] *= temp;
            }
            return ans;
        }
    }
}
