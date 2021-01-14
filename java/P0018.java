/**
 * P0017:四数之和
 * 题意：找到四个数和为target
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P0018 {
    public static void main(String[] args) {
        
    }
    static class Solution {
        List<List<Integer>> res = new ArrayList<>();
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if(nums==null || nums.length < 4 )return res;
            Arrays.sort(nums);
            for(int i = 0;i < nums.length-3;i++){
                if(i!=0 && nums[i]==nums[i-1])continue;
                for (int j = i+1; j < nums.length-2; j++) {
                    if(j!=i+1 && nums[j]==nums[j-1])continue;
                    int k=j+1,l=nums.length-1;
                    while(k < l){
                        if(nums[i]+nums[j]+nums[k]+nums[l] > target)l--;
                        else if (nums[i]+nums[j]+nums[k]+nums[l] < target)k++;
                        else{
                            List<Integer> seq = new ArrayList<>();
                            seq.add(nums[i]);
                            seq.add(nums[j]);
                            seq.add(nums[k]);
                            seq.add(nums[l]);
                            res.add(seq);
                            while(k < l && nums[k]==nums[k+1])k++;
                            while(k < l && nums[l]==nums[l-1])l--;
                            if(k < l-1){
                                k++;
                                l--;
                            }else{
                                break;
                            }
                        }
                    }
                }
            }
            return res;
        }
    }
}
