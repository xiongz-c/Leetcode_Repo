import java.util.*;

/**
 * P0049: Group Anagrams
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
