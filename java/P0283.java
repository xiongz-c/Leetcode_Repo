/**
 * P0283:Move zeros
 * 题意：把数组里的0全部移到最后面,不能新开数组，操作数尽可能少
 * 做法：类似冒泡排序那样不断交换？但是那样复杂度可能比较高
 * 正解：不要一位一位移动，想办法记录位置，直接做swap
 */

public class P0283 {
    public static void main( String[] args ) {
        int[] arr = new int[]{0,1,0,3,12};
        Solution s = new Solution();
        s.moveZeroes( arr );
        for (int e:arr){
            System.out.print( e + "," );
        }
    }

    static class Solution{
        public void moveZeroes(int[] nums) {
            int cnt = 0;
            int len = nums.length;
            for (int i = 0;i < nums.length;i++){
                if ( nums[i] == 0 ){
                    cnt++;
                }else{
                    nums[i-cnt] = nums[i];
                }
            }
            //cnt=1时是操作到len-1，所以下届是这个
            for (int i = len - 1; i > len- 1 - cnt ;i--){
                nums[i] = 0;
            }
        }
    }
}
