/**
 * P0172：
 * 题意：找一堆数中阶乘（n！）答案里0的个数
 * 题解：
 */

public class P0172 {
    public static void main( String[] args ) {
        Solution s = new Solution( );
        System.out.println( s.trailingZeroes( 5 ) );
    }

    static class Solution {
        public int trailingZeroes( int n ) {
            int ans = 0;
            int tmp = n/5;
            while(tmp != 0){
                ans += tmp;
                tmp /= 5;
            }
            return ans;
        }
    }
}
