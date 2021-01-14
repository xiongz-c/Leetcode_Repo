/**
 * Leetcode周赛No.200第一题 统计好三元组
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 ：
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 *
 */
package week200;

public class P0001 {
    public static void main( String[] args ) {
        int[] arr = new int[]{3,0,1,1,9,7};
        int a=7,b=2,c=3;
        System.out.println( new Solution().countGoodTriplets( arr,a,b,c ) );
    }
    static class Solution{
        public int countGoodTriplets(int[] arr, int a, int b, int c) {
            int len = arr.length;
            int cnt = 0;
            for (int i = 0;i < len ;i++){
                for (int j = i+1;j < len;j++){
                    for (int k =j+1;k < len;k++){
                        if(Math.abs( arr[i] - arr[j] ) <= a && Math.abs( arr[i] - arr[k] ) <= c && Math.abs( arr[j] - arr[k] ) <= b){
//                            System.out.println( arr[i] + " " + arr[j] + " " + arr[k] + " " );
                            cnt++;
                        }
                    }
                }
            }
            return cnt;
        }
    }
}
