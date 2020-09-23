/**
 * P0010:正则表达式的匹配
 * 题意：给定字符串s和字符串规律p，实现 . 和 * 的匹配规则
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 题解：动态规划，用一个二维数组dp[i][j]来表示字符规则s到第i位能否匹配p的第j位
 */
public class P0010 {
    public static void main( String[] args ) {
        String s = "aa";
        String p = ".*";
        System.out.println( new Solution().isMatch( s,p ) );
    }
    static class Solution {
        public boolean matches(String s, String p, int i, int j){
            if(i==0)return false;
            if(s.charAt( i-1 ) == p.charAt( j-1 ))return true;
            return p.charAt( j-1 ) == '.';
        }
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length()+1][p.length()+1];
            dp[0][0] = true;
            for (int i = 0;i <= s.length();i++){
                for (int j = 1;j <= p.length();j++){
                    if(p.charAt( j-1 ) == '*'){
                        dp[i][j] = dp[i][j-2];
                        if(matches( s,p,i,j-1 ))dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }else{
                        if(matches( s,p,i,j ))dp[i][j] = dp[i-1][j-1];
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
