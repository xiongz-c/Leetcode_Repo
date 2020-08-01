import java.util.ArrayList;
import java.util.List;

/**
 * p0632：Smallest Range Covering Elements from K Lists
 * 题意：给k个升序排列的数组，找到一个最小的区间，使得每个数组中都有元素在区间内。
 * tips:定义如果 (b-a < d-c) 或者(在 b-a == d-c 时 a < c)，则区间 [a,b] 比 [c,d] 小。
 */
public class P0632 {
    public static void main( String[] args ) {

    }
    static class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int begin=0,end=0;


            return new int[]{begin,end};
        }
    }
}
