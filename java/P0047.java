import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * P0047:全排列II
 * 题意：给一个 包含重复数字 的数组， 返回它不重复的全排列
 * 题解：
 */
public class P0047 {
    public static void main( String[] args ) {
        int[] input = new int[]{1};
        System.out.println( new Solution( ).permuteUnique( input ).toString( ) );
    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<>( ) ;
        public List<List<Integer>> permuteUnique( int[] nums ) {
            //将int数组转换为Integer数组
            //先将int数组转换为数值流
            IntStream stream = Arrays.stream( nums );
            //流中的元素全部装箱，转换为流 ---->int转为Integer
            Stream<Integer> integerStream = stream.boxed( );
            //将流转换为数组
            Integer[] integers = integerStream.toArray( Integer[]::new );
            Arrays.sort( integers );
            permute( integers , 0 , nums.length - 1 );
            return ans;
        }

        public void permute( Integer[] nums , int beg , int end ) {
            if ( end < 0 ) return;
            if ( beg == end ) {
                ans.add( new ArrayList<Integer>( Arrays.asList( nums )) );
            }else{
                for(int i=beg; i<=end; i++) {
                    if(move_repeat_core( nums,beg,i )){
                        swap(nums,i,beg); //交换前缀，使其产生下一个前缀
                        permute(nums, beg+1, end);
                        swap(nums,beg,i); //将前缀换回，继续做上一个前缀的排列
                    }
                }
            }
        }

        public void swap( Integer[] nums , int a , int b ) {
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }

        public boolean move_repeat_core(Integer[] nums, int beg, int end){
            for (int i = beg;i < end;i++){
                if( nums[i].equals( nums[end] ) )return false;
            }
            return true;
        }

    }
}
