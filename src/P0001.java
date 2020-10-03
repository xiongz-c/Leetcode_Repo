/**
 * P0001:两数之和
 */

 class P0001{
     public static void main(String[] args) {
         
     }
     static class Solution{
        public int[] twoSum(int[] nums, int target) {
            int[] arr = new int[nums.length];
            for(int i = 0;i < nums.length;i++){
                arr[i] = nums[i];
            }
            Arrays.sort(arr);
            int left = 0,right = nums.length-1;
            while(arr[left]+arr[right]!=target){
                if(left < nums.length-1 && arr[left]+arr[right]<target)left++;
                else if(right > 0 && arr[left]+arr[right]>target)right--;
                else break;
            }
            int[] ans = new int[]{-1,-1}; 
            for(int i = 0;i < nums.length;i++){
                if(nums[i]==arr[left] && ans[0]==-1)ans[0] = i;
                if(nums[i]==arr[right])ans[1] = i;
            }
            return ans;
            
        }
        
     }
 }