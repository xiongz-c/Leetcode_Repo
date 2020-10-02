/**
 * P0039:组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 
 */

class P0039{
    public static void main(String[] args) {
        
    }
    static class Solution{
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            dfs(candidates,0,target);
            return ans;
        }

        public void dfs(int[] array, int pos, int rest){
            if(rest == 0){
                ans.add(new ArrayList<>(sequence));
                return;
            }
            if(pos == array.length||array[pos] > rest)return;
            dfs(array,pos+1,rest);
            int repeat = rest/array[pos];
            for(int i = 1;i <= repeat;++i){
                sequence.add(array[pos]);
                dfs(array,pos+1,rest - i*array[pos]);
            }
            for (int i = 1;i <= repeat; ++i){
                sequence.remove( sequence.size() - 1 );
            }


        }
    }
}