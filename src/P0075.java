/**
 * P0075:颜色分类
 * 题意：给出只有三个数字012的数组，要求原地排序，复杂度on
 * 题解：用两个指针，一个指向0的末尾下一个，一个指向1的末尾下一个，
 * 遇到0：与p0交换，做一个判断，如果p0<p1，证明p0指向的是第一个1，所以换走的是1，需要换回来，所以i再与p1换一下
 * 遇到1：直接交换
 * 换了哪个哪个的指针就要前移一个
 */
class P0075{
    public static void main(String[] args) {
        
    }
    static class Solution {
        void swap(int[] nums,int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        public void sortColors(int[] nums) {
            int p0=0,p1=0;
            for(int i = 0;i < nums.length;i++){
                if(nums[i]==0){
                    swap(nums,i,p0);
                    if(p0<p1){
                        swap(nums,i,p1);
                    }
                    p0++;p1++;
                }else if(nums[i]==1){
                    swap(nums,i,p1);
                    p1++;
                }
            }
        }
    }
}