/**
 * P0032:求最长匹配括号字串
 * 题意：给一段括号，求出合法的最长字串
 * 题解：dp/stack/双指针，这里用最后一种，很精妙
 */

class P0032{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int longestValidParentheses(String s) {
            int left = 0,right = 0;
            int len = s.length();
            int max_len = -1;
            for(int i = 0;i < len;i++){
                if(s.charAt(i)=='(')left++;
                else right++;
                if(left==right)max_len = Math.max(max_len,2*left);
                if(right > left){
                    left = 0;right = 0;    
                }         
            }
            left = 0;right = 0;
            for(int i = len-1;i > -1;i--){
                if(s.charAt(i)=='(')left++;
                else right++;
                if(left==right)max_len = Math.max(max_len,2*left);
                if(right < left){
                    left = 0;right = 0;    
                }            
            }
            return max_len;
        }
    }
}