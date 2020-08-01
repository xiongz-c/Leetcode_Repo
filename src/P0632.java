import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * p0632：Smallest Range Covering Elements from K Lists
 * 题意：给k个升序排列的数组，找到一个最小的区间，使得每个数组中都有元素在区间内。
 * tips:定义如果 (b-a < d-c) 或者(在 b-a == d-c 时 a < c)，则区间 [a,b] 比 [c,d] 小。
 * 题解：没做出来，参考leetcode官方题解：
 * 1.使用堆进行排序
 * 2.哈希表+滑动窗口
 * 3.二分答案应该也能做（我首先想到的思路，但是没有想好具体实现）
 * 看完代码之后觉得好像蛮简单的...
 */
public class P0632 {
    public static void main( String[] args ) {

    }

    public int[] smallestRange( List<List<Integer>> nums ) {
        int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size( );
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>( Comparator.comparingInt( index -> nums.get( index ).get( next[index] ) ) );


        for (int i = 0; i < size; i++) {
            priorityQueue.offer( i );
            max = Math.max( max , nums.get( i ).get( 0 ) );
        }
        while (true) {
            int minIndex = priorityQueue.poll( );
            int curRange = max - nums.get( minIndex ).get( next[minIndex] );
            if ( curRange < minRange ) {
                minRange = curRange;
                rangeLeft = nums.get( minIndex ).get( next[minIndex] );
                rangeRight = max;
            }
            next[minIndex]++;
            if ( next[minIndex] == nums.get( minIndex ).size( ) ) {
                break;
            }
            priorityQueue.offer( minIndex );
            max = Math.max( max , nums.get( minIndex ).get( next[minIndex] ) );
        }
        return new int[]{rangeLeft , rangeRight};
    }
}
