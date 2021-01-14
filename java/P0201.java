/**
 * P0201:Bitwise AND of Numbers Range
 * 题意：给定一个区间[m,n]，求区间内所有数的按位与
 * 做法：黑魔法！用力想！暴力是必不可能的
 * 没想出来，题解里面有一个非常巧妙的解法,标准答案了
 */

public class P0201 {
    public static void main( String[] args ) {

    }

    static class Solution {
        public int rangeBitwiseAnd( int m , int n ) {
            int i = 0;
            while (m != n) {
                m >>= 1;
                n >>= 1;
                i++;
            }
            return m << i;
        }
    }
}
