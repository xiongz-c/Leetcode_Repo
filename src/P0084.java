import java.util.Stack;

/**
 * P0084:
 *
 */
public class P0084 {
    public static void main( String[] args ) {
        int[] arr = new int[]{5,5,1,7,1,1,5,2,7,6};
        Solution s = new Solution();
        System.out.print( s.largestRectangleArea( arr ) );
    }
    static class Solution{
        public int largestRectangleArea(int[] heights) {
            if(heights.length==0)return 0;
            int minHeight = Integer.MAX_VALUE;
            int len = heights.length;
            for (int e : heights)if(minHeight > e)minHeight = e;
            int ans = minHeight * len;
            Stack<Integer> stack = new Stack<>();
            //构造单调递增的单调栈：比前面还要矮的就没有意义，因为有比他矮还比他长的
            int nowArea;
            stack.push( 0 );
            ans = Math.max( ans,heights[0] );
            for (int i = 1; i < len;i++){
                ans = Math.max( ans,heights[i] );
                if( !stack.empty() && heights[i] < heights[stack.peek( )] ){
                    while( !stack.empty() && heights[i] < heights[stack.peek()]){
                        int tmp = stack.pop();
                        if(!stack.empty())nowArea = heights[tmp] * (i - stack.peek() - 1);
                        else nowArea = heights[tmp] * (i);
                        ans = Math.max( ans,nowArea );
                    }
                    if(!stack.empty())nowArea = heights[i] * (i - stack.peek());
                    else nowArea = heights[i] * (i+1);
                }else{
                    nowArea = heights[stack.peek()] * (i-stack.peek()+1);
                }
                stack.push( i );
                ans = Math.max( ans,nowArea );
            }
            int i = stack.pop();
            while( !stack.empty()){
                int tmp = stack.pop();
                if(!stack.empty())nowArea = heights[tmp] * (i - stack.peek());
                else nowArea = heights[tmp] * (i  - 1);
                ans = Math.max( ans,nowArea );
            }
            return ans;
        }
    }
}
