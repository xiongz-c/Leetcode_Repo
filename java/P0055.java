/**
 * P0055:Jump Game
 * 题意：给一个数组，每个元素表示从这里你最多可以跳几步，确定你是否可以到达终点
 * 做法：从最后一个元素往前推看能不能回到起点
 */

public class P0055 {
    public static void main( String[] args ) {
        //这个题就不用测试了吧
    }
    static class Solution{
        public boolean canJump(int[] nums) {
            int now = nums.length - 1,len = nums.length;

            for (int i = len-2;i >= 0;i--){
                if(nums[i]+i >= now){
                    now = i;
                }
            }
            return now==0;
        }
    }
}
