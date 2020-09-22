/**
 * P0004:寻找两个正序数组的中位数
 * 题意：给定两个大小为m，n的，从小到大排序的数组，找出两个数组的中位数，要求时间复杂度为O（log（m+n））
 * 题解：看到log想到二分的思想，但是不能merge数组，可以对问题进行转换，找第k小的数。
 * 对于两个数组，找第k小的数，相当于先找两个数组的第k/2-1大的数，然后根据他们的大小关系排除掉一个数组的前k/2-1
 * 然后更新k的值和数组，重复这个过程
 */
public class P0004 {
    public static void main( String[] args ) {
        int[] nums1 = new int[]{3};
        int[] nums2 = new int[]{1,2,4,5,6};
        System.out.println( new Solution( ).findMedianSortedArrays( nums1 , nums2 ) );
    }

    static class Solution {
        public double findMedianSortedArrays( int[] nums1 , int[] nums2 ) {
            int m = nums1.length;
            int n = nums2.length;
            boolean flag = ( m + n ) % 2 == 0;//odd is false, even is true
            int k;
            double ans;
            if ( flag ) {//even number, mid is the average of (m+n)/2 and (m+n)/2+1
                k = ( m + n ) / 2;
                ans = (double) solve( k , nums1 , nums2 , 0 , 0 ) + solve( k + 1 , nums1 , nums2 , 0 , 0 );
                ans /= 2;
            } else {
                k = ( m + n ) / 2 + 1;
                ans = solve( k , nums1 , nums2 , 0 , 0 );
            }
            return ans;
        }

        public int solve( int k , int[] arr1 , int[] arr2 , int beg1 , int beg2 ) {
            int idx = k / 2;
            if ( beg1 == arr1.length ) {
                return arr2[beg2 + k - 1];
            } else if ( beg2 == arr2.length ) {
                return arr1[beg1 + k - 1];
            }
            if ( idx > arr1.length - beg1 - 1 && idx <= arr2.length - beg2 - 1 ) {
                if ( arr1[arr1.length - 1] <= arr2[beg2 + idx-1] )
                    return solve( k - ( arr1.length - beg1 ) , arr1 , arr2 , arr1.length , beg2 );
                else
                    return solve( k - idx , arr1 , arr2 , beg1 , beg2 + idx );
            } else if ( idx > arr2.length - beg2 - 1 && idx <= arr1.length - beg1 - 1 ) {
                if ( arr2[arr2.length - 1] <= arr1[beg1 + idx-1] )
                    return solve( k - ( arr2.length - beg2 ) , arr1 , arr2 , beg1 , arr2.length );
                else
                    return solve( k - idx , arr1 , arr2 , beg1 + idx , beg2 );
            }
            if ( k == 1 ) return Math.min( arr1[beg1] , arr2[beg2] );

            if ( arr1[beg1 + idx-1] <= arr2[beg2 + idx-1] ) {
                return solve( k - idx , arr1 , arr2 , beg1 + idx , beg2 );
            } else {
                return solve( k - idx , arr1 , arr2 , beg1 , beg2 + idx );
            }
        }
    }
}
