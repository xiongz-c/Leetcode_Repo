import java.util.ArrayList;
import java.util.List;

/**
 * P0154:Find Minimum in Rotated Sorted Array II
 * 题意：找到旋转数组中的最小值
 * 做法：类似于P0033，甚至更简单，难点在于数组有重复，需要考虑
 * 笨方法，直接去重
 * 奇妙方法：不用找反转点，使用类似二分的做法
 */
public class P0154 {
    public static void main( String[] args ) {
        Solution s = new Solution( );
        int[] arr = new int[]{2,2,2,0,1};
        System.out.println( s.findMin( arr ) );
    }

    static class Solution {
//        public int findPivot( int[] arr , int begin , int end ) {
//            if ( begin > end ) return -1;
//            if ( begin == end ) return begin;
//            int mid = begin + ( ( end - begin ) >>> 1 );
//            if ( mid < end && arr[mid] > arr[mid + 1] ) return mid;
//            if ( mid > begin && arr[mid - 1] > arr[mid] ) return mid - 1;
//            if ( arr[begin] < arr[mid] ) return findPivot( arr , mid + 1 , end );
//            else return findPivot( arr , begin , mid - 1 );
//        }
//
//        public int findMin( int[] nums ) {
//            List<Integer> list = new ArrayList<>( );
//            for (int i = 0; i < nums.length; i++) {
//                if ( i == 0 ) list.add( nums[i] );
//                else if ( nums[i - 1] != nums[i] ) list.add( nums[i] );
//            }
//            int[] arr = new int[list.size( )];
//            for (int i = 0;i < list.size();i++){
//                arr[i] = list.get( i );
//            }
//            int pivot = findPivot( arr,0,arr.length - 1);
//            if(pivot==-1)return arr[0];
//            else if(pivot!=arr.length-1)return arr[pivot+1];
//            else return arr[0];
//        }
        public int findMin(int[] nums){
            int lo = 0, hi = nums.length - 1;
            while(lo < hi){
                int mid = (lo+hi) >>> 1;
                if(nums[mid] > nums[hi]) lo = mid +1;
                else if(nums[mid] < nums[hi]) hi = mid;
                else hi--;
            }
            return nums[lo];
        }
    }

}
