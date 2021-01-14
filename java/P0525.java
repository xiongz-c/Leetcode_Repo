import java.util.HashMap;
import java.util.Map;

/**
 * P0525:Contiguous Array
 * 题意：給一串01数列，找到最长的0和1数量相等的字串
 * 做法：没想出来，看了题解。没有复杂的算法，利用map快速查找的特性实现O（1）的比对
 * leetcode上更快的算法是把map用一个【2*len+1】的数组模拟，这种写法比较繁琐，优化的程度也不是特别大，贴在下面吧。
 */

public class P0525 {
    public static void main( String[] args ) {

    }
    static class Solution{
        public int findMaxLength(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(  );
            int sum = 0,max = 0;
            int len = nums.length;
            for (int i = 0;i < len;i++){
                sum += (nums[i] == 0 ? -1: 1 );
                if(!map.containsKey( sum )){
                    map.put( sum,i );
                }else{
                    //这种情况是两个相同的sum之间的数肯定是相等的
                    max = Math.max(max,i - map.get( sum )) ;
                }
                //这种情况是直接sum=0即这段就是相等的
                if(sum==0)max = Math.max(max,i+1);
            }
            return max;
        }
    }
}

//class Solution {
//
//    public int findMaxLength(int[] nums) {
//
//        int arr[]=new int[2*nums.length+1];
//        int count=0 , maxlen=0;
//        Arrays.fill(arr,-2);
//        arr[nums.length]=-1;
//        for(int i=0;i<nums.length;i++){
//            count=count+(nums[i]==0?-1:1);
//            if(arr[count+nums.length]>=-1)
//                maxlen=Math.max(maxlen,i-arr[count+nums.length]);
//            else
//                arr[count+nums.length]=i;
//
//
//        }
//
//        return maxlen;
//    }
//}
