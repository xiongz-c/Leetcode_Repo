/**
 * problem 33: Search in Rotated Sorted Array
 * 分成两段的数组进行二分搜索
 * 本题需要两个函数：找到分界点/二分搜索
 * 找到rotate pivot（实际的数组起点）后，target相对于pivot的位置安排在不同区间进行二分搜索
 */

public class P0033 {
    public static void main( String[] args ) {
        int[] arr = new int[]{3,4,5,6,1,2};
        Solution now = new Solution( );
        System.out.println( now.search( arr, 2) );
    }
    static class Solution {
        public int search( int[] nums , int target ) {
            int pivot = findPivot( nums , 0 , nums.length - 1 );
            if ( pivot == -1 )return binarySearch( nums,0,nums.length,target );
            if(nums[pivot] == target)return pivot;
            if(nums[0] <= target)return binarySearch( nums, 0,pivot+1,target );
            else return binarySearch( nums, pivot+1,nums.length, target );
        }

        public int findPivot( int[] arr , int begin , int end ) {
            if ( begin > end ) return -1;
            if ( begin == end ) return begin;
            int mid = begin + (( end - begin ) >>> 1);
            if ( mid < end && arr[mid] > arr[mid + 1] ) return mid;
            if ( mid > begin && arr[mid - 1] > arr[mid] ) return mid - 1;
            if ( arr[begin] < arr[mid] ) return findPivot( arr , mid + 1 , end );
            else return findPivot( arr , begin , mid - 1 );
        }

        public int binarySearch( int[] arr , int first , int last , int target ) {
            int mid;
            while (first < last) {
                mid = first + (( last - first ) >>> 1);
                if ( arr[mid] < target ) first = mid + 1;
                else last = mid;
            }
            if(first>arr.length-1)return -1;
            return arr[first] == target ? first : -1;
        }
    }
}