import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * P0040:组数总和II
 * 题意：给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 * 每个数字组合只能用一次
 * 做法：常规递归。注意【数字组合】要去重
 */
public class P0040 {
    public static void main( String[] args ) {

    }
    static class Solution{
        List<int[]> freq = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        public List<List<Integer>> combinationSum2( int[] candidates, int target) {
            Arrays.sort(candidates);
            for (int num : candidates) {
                int size = freq.size();
                if (freq.isEmpty() || num != freq.get(size - 1)[0]) {
                    freq.add(new int[]{num, 1});
                } else {
                    ++freq.get(size - 1)[1];
                }
            }
            dfs(0, target);
            return ans;
        }

        public void dfs(int pos, int rest){
            if(rest == 0){//达到要求
                ans.add( new ArrayList<>( sequence ) );
                return;
            }
            if(pos == freq.size() || rest < freq.get( pos )[0]){//不可能达到要求了
                return;
            }
            dfs(pos+1,rest);

            int max_num = Math.min( rest/freq.get(pos)[0], freq.get( pos )[1] );
            for (int i = 1;i <= max_num;i++){
                sequence.add( freq.get( pos )[0] );
                dfs( pos + 1,rest - i*freq.get( pos )[0] );

            }
            for (int i = 1;i <= max_num; ++i){
                sequence.remove( sequence.size() - 1 );
            }
        }
    }

}
