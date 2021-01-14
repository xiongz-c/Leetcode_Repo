/**
 * P0047：全排列
 * 题意：给定 没有重复数字 的数组，给出全排列
 * 题解：没有重复数字，比下一题简单。可以开一个数组记录已经访问过的数，通过回溯解决
 */
class P0046{
    public static void main(String[] args) {
        
    }
    static class Solution{
        List<List<Integer>> res;
        public void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        public void dfs(int[] nums,int len,ArrayList<Integer> arr){
            if(len==nums.length)res.add(new ArrayList<>(arr));
            else{
                for(int i = len;i < nums.length;i++){
                    swap(nums,len,i);
                    arr.add(nums[len]);
                    dfs(nums, len+1,arr);
                    arr.remove(arr.size()-1);
                    swap(nums,i,len);
                }
            }
        }
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            dfs(nums,0, new ArrayList<Integer>());
            return res;
        }
    }
}