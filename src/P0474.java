/**
 * P0474:一和零
 * 题意：给出由1和0组成的字符串数组，和m个0，n个1，求最多可以组成数组中几个串。
 * 题解：二维背包问题
 * 
 */
class P0474{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] counter = count_0_1(strs);
            int[][] dp = new int[m+1][n+1];
            for(int i = 0;i < strs.length;i++){
                for(int j = m;j >= counter[i][0];j--){
                    for(int k = n;k >= counter[i][1];k--){
                        dp[j][k] = max(dp[j][k], 1+dp[j-counter[i][0]][k-counter[i][1]]);
                    }
                }
            }
        }

        public int[][] count_0_1(String[] strs){
            int[][] cnt = new int[strs.length][2];
            for(int i = 0;i < strs.length;i++){
                String str = strs[i];
                int cnt_1 = 0;
                for(int j = 0;j < str.length();j++){
                    if(str.charAt(j)=='1')cnt_1++;
                }
                cnt[i][0] = str.length() - cnt_1;
                cnt[i][1] = cnt_1;
            }
            return cnt;
        }
    }
}