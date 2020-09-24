import java.util.ArrayList;
import java.util.List;

/**
 * P0017. 电话号码的字母组合
 * 题意：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母
 */
public class P0017 {
    public static void main( String[] args ) {
        String in = "23";
        System.out.println( new Solution().letterCombinations( in ).toString() );
    }
    static class Solution{
        List<String> ans = new ArrayList<>(  );
        public List<String> letterCombinations( String digits) {
            if(digits.equals(""))return new ArrayList<>(  );
            char[][] table = new char[][]{{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'}
            ,{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
            char[] input = digits.toCharArray();
            dfs( input,table,0,"" );
            return ans;
        }

        public void dfs(char[] input, char[][] table, int index, String now){
            if(index==input.length-1){
                for (char e : table[input[index]-'1']){
                    ans.add( now + e );
                }
            }else{
                for (char e : table[input[index]-'1']){
                    dfs( input,table,index+1,now+e );
                }
            }
        }
    }
}
