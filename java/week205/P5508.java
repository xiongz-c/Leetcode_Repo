/**
 * P0058:数的平方等于两数乘积的方法数
 * 给你两个整数数组 nums1 和 nums2 ，请你返回根据以下规则形成的三元组的数目（类型 1 和类型 2 ）：
 * 类型 1：三元组 (i, j, k) ，如果 nums1[i]2 == nums2[j] * nums2[k] 其中 0 <= i < nums1.length 且 0 <= j < k < nums2.length
 * 类型 2：三元组 (i, j, k) ，如果 nums2[i]2 == nums1[j] * nums1[k] 其中 0 <= i < nums2.length 且 0 <= j < k < nums1.length
 * 题解：hash map 其实挺暴力的
 *
 */
package week205;

import java.util.HashMap;
import java.util.Map;

public class P5508 {
    public static void main( String[] args ) {

    }
    static class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            return countPair( nums1, nums2 ) + countPair( nums2, nums1 );
        }
        public int countPair(int[] nums1, int[] nums2){
            int ans = 0;
            int len1 = nums1.length,len2 = nums2.length;
            if(len1 < 2) return ans;
            Map<Long, Integer> map = new HashMap<>(  );
            for (int i = 0;i < len1-1;i++){
                for (int j = i+1;j < len1;j++){
                    long tmp = (long)nums1[i] * nums1[j];
                    map.put(tmp, map.getOrDefault(tmp,0)+1);// 一种非零+1的标准写法
                }
            }
            for (int i = 0;i < len2;i++){
                long res = (long)nums2[i] * nums2[i];
                if(map.containsKey( res )) ans += map.get( res );
            }
            return ans;
        }
    }
}
