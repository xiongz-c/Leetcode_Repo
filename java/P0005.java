/**
 * P0005:最长回文子串
 * 题意：改定一个字符串，求最长回文字串
 * 题解：dp 转移方程P(i,j)=P(i+1,j-1)^S(i)==S(j)
 */
public class P0005 {
    public static void main( String[] args ) {

    }

    static class Solution {
        public String longestPalindrome( String s ) {
            if(s==null)return null;
            if(s.length()==1)return s;
            if(s.length()==2)return s.charAt( 0 )==s.charAt( 1 )?s:s.substring(0,1);
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            String ans = "";
            for (int l = 0;l < len;l++){
                for (int i = 0;i + l < len;i++){
                    int j = i+l;
                    if(l==0){
                        dp[i][j]=true;
                    }else if(l == 1){
                        dp[i][j] = (s.charAt( i ) == s.charAt( j ));
                    }else{
                        dp[i][j] = ((s.charAt( i ) == s.charAt( j )) && dp[i+1][j-1]);
                    }
                    if(dp[i][j] && l+1 > ans.length()){
                        ans = s.substring(i, i + l + 1);
                    }
                }
            }
            return ans;
        }
    }

}
