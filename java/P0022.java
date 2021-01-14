import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * P0022. 括号生成
 * 题意：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 题解：可以暴力枚举，然后
 */
public class P0022 {
    public static void main( String[] args ) {
        System.out.println( new Solution().generateParenthesis( 3 ).toString() );
    }
    static class Solution {
        public List<String> generateParenthesis( int n) {
            if(n==0)return new ArrayList<>(  );
            List<String> ans = new ArrayList<>(  );
            if(n==1){
                ans.add("()");
                return ans;
            }
            long total = 1 << (2*n);
            while (total-->-1){
                if(check( total , n))ans.add( build( total ) );
            }
            return ans;
        }
        boolean check(Long num,int n){
            Stack<Long> s = new Stack<>();
            int sum_1 = 0,sum_0 = 0;
            if((num & 1) == 1)return false;
            while(num != 0){
                if((num < 2)&&(num & 1) == 0)return false;
                long now = num & 1;
                if(now==1)sum_1++;
                else sum_0++;
                if(s.empty()){
                    if(now==1)return false;
                    s.push( now );
                }
                else{
                    if( now == 1 ){
                        s.pop();
                    }else{
                        s.push( now );
                    }
                }
                num >>= 1;
                if(sum_1 > n || sum_0 > n)return false;
            }
            if(sum_1!=n)return false;
            return s.empty();
        }
        String build(Long num){
            StringBuilder ans = new StringBuilder( );
            while(num != 0) {
                long now = num & 1;
                if(now==1){
                    ans.insert( 0 , "(" );
                }else {
                   ans.insert( 0 , ")" );
                }
                num >>= 1;
            }
            return ans.toString( ).toString();
        }
    }
}
