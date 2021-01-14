import java.util.HashSet;
import java.util.Set;

/**
 * P0202: happy number
 * 题意：对一个正整数，把每一位的数字拆开，平方加和后得到一个新的整数，不断进行此操作，如果最后得到的值是1，则称这个数为happy number
 * 做法：看了几种思路，记录一下我觉得写得最好的一种。这个问题无非是可以归结为一个“找循环节”的问题，如果循环了，肯定就到不了1了。
 * 如果没有循环，总会到1进入死循环，所以只需要用一个while和hashset就可以了【应该是这题的标准解法】
 * 拓展：对于其他的找循环节的问题，如链表判环的问题，能否也利用hashset的方式来做？跟快慢指针比效率如何？
 */
public class P0202 {
    public static void main( String[] args ) {
        int number = 18;//(int)(Math.random()*10000);
        System.out.println( number );
        Solution s = new Solution();
        System.out.println( s.isHappy( number ) );
    }

    static class Solution{
        public boolean isHappy(int n) {
            if(n==1)return true;
            Set<Integer> num = new HashSet<>(  );
            while(n!=1){
                int sum = 0;
                while(n!=0){
                    sum += (n%10)*(n%10);
                    n /= 10;
                }
                if(num.contains( sum ))return false;
                num.add( sum );
                n = sum;
            }
            return true;
        }
    }
}
