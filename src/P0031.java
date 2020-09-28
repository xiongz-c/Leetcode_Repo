
public class Solution{
    
    public static void main(String[] args) {
        
    }
    static class Solution{

        public void swap(int[] nums, int x,int y){
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        } 
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int tr = -1;
            for(int i = len-1;i > 0;i--){
                if(nums[i-1] < nums[i]){
                    tr = i;
                    break;
                }
            }
            if(tr==-1){
                Arrays.sort(nums);
                return;
            }
            int left = tr-1;
            for(int i = tr;i < len;i++){
                if(nums[i] < nums[tr] && nums[i] > left){
                    tr = i;
                }
            }
            swap(nums,left,tr);
            Arrays.sort(nums,tr,len-1);
            
        }
    }
}