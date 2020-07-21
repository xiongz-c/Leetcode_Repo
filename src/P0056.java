import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * P:Merge Intervals
 */

public class P0056 {
    public static void main( String[] args ) {
        int[][] test = new int[][]{{1,4},{0,4}};
        Solution sol = new Solution();
        int[][] ans = sol.merge( test );
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
        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length <= 1) {
                return intervals;
            }
            //Sorting based on both arrays 1st element
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);//lambda写比较器
            List<int[]> result= new ArrayList<int[]>();
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
    static class Cmp implements Comparator<int[]> {
        @Override
        public int compare( int[] o1 , int[] o2 ) {
            return o1[1]-o2[1];
        }
    }
}
