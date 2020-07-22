import java.util.ArrayList;
import java.util.List;

/**
 * P0057:Insert Interval
 * 题意：相当于在原来的数组集里面插入一个新的数组，再做merge
 * 做法：也是和题意一样直白，merge的部分套用上一题的做法，insert的话就是用最短的时间消耗找到合适的插入位置，我这个实现写的比较啰嗦，
 * 但是时间复杂度上倒是没有问题，要是直接调arraylist来sort几次找合适的位置就比较消耗时间，还是自己实现合适位置插入比较好。
 */

public class P0057 {
    public static void main( String[] args ) {
        int[][] test = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        Solution sol = new Solution();
        int[][] ans = sol.insert( test ,new int[]{4,8});
        for (int[] e:ans){
            System.out.print( "[" );
            for (int f : e){
                System.out.print( f );
                System.out.print( ",");
            }
            System.out.print( "]" );
            System.out.println(  );
        }
    }
    static class Solution{
        public int[][] insert(int[][] intervals, int[] newInterval) {
            if (intervals == null || intervals.length==0) {
                return new int[][]{newInterval};
            }
            int arrLen = intervals.length;
            boolean flag = false;
            for(int[] arr:intervals){
                if(arr[1] >= newInterval[0] && arr[0] <= newInterval[1]){
                    arr[1] = Math.max( arr[1], newInterval[1] );
                    arr[0] = Math.min( arr[0], newInterval[0] );
                    flag = true;
                    break;
                }
            }
            if(!flag){
                int[][] beg = new int[arrLen+1][];
                for (int i = 0;i < arrLen;i++)
                {
                    if(i == arrLen-1 && intervals[i][1] < newInterval[0]){
                        beg[arrLen-1] = intervals[i];
                        beg[arrLen] = newInterval;
                    }else if(intervals[i][0] > newInterval[1]) {
                        beg[i+1] = intervals[i];
                    }else{
                        beg[i] = intervals[i];
                    }
                }
                for (int i = 0;i < arrLen+1;i++){
                    if(beg[i] == null){
                        beg[i] = newInterval;
                        break;
                    }
                }
                intervals = beg;
            }
            List<int[]> result= new ArrayList<>();
            //Take the first interval and add it to the result
            int[] curr = intervals[0];
            result.add(curr);

            for(int[] arr:intervals)
            {
                int currBegin = curr[0];
                int currEnd= curr[1];
                int nextBegin= arr[0];
                int nextEnd= arr[1];
                if(currEnd >= nextBegin)
                {
                    //By changing the ending value in curr, it will automatically
                    //change in the result
                    curr[1]= Math.max(currEnd, nextEnd);
                }
                else
                {
                    //There is no overlap, so we will update the current
                    curr= arr;
                    result.add(curr);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
}
