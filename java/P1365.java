/**
 * P1365:有多少小于当前数字的数字
 * 题意：找数组中某个数比他小的数的数量
 * 题解：暴力遍历，先排序再找，用counter存下来
 */
class P1365{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] counter = new int[101];
            for(int i = 0;i < nums.length;i++){
                counter[nums[i]]++;
            }
            int[] sum = new int[101];
            for(int i = 1;i < 101;i++){
                sum[i] += counter[i-1] + sum[i-1];
            }
            int[] ans = new int[nums.length];
            for(int i = 0;i < nums.length;i++){
                ans[i] = sum[nums[i]];
            }
            return ans;
        }
    }
}