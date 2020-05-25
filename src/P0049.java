import java.util.*;

/**
 * P0049: Group Anagrams
 * 把由相同字符组成的字符串归为一类，并输出归类后的list
 * 自然想到分类的标准：字符串拆成数组后排序重新组合后相等的字符串为一类
 * 为了存储这个 标准串（排序后的字符串），自然想到用map的结构存储
 * 记录一个cnt，维持下标递增
 */

public class P0049 {
    public static void main( String[] args ) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        P0049.Solution solution = new P0049.Solution();
        System.out.println( solution.groupAnagrams( arr ));
    }

    static class Solution{
        public List<List<String>> groupAnagrams( String[] strs) {
            int cnt = 0;
            List<List<String>> ans = new ArrayList<>(  );
            Map<String,Integer> map = new HashMap<>(  );
            for (String str : strs){
                char[] chars = str.toCharArray();
                Arrays.sort( chars );
                String s = String.valueOf( chars );
                if(map.containsKey( s )){
                    ans.get( map.get( s ) ).add( str );
                }else{
                    map.put( s,cnt );
                    ans.add( new ArrayList<>(  ) );
                    ans.get( cnt++ ).add( str );
                }
            }
            return ans;
        }
    }
}
