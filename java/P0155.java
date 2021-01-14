import java.util.Stack;

/**
 * P0155：min stack
 * 题意：和146类似，也是设计数据结构的题目。设计一个stack，可以返回最小值的那种
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 做法：冥冥中觉得DSAA是不是做过，使用两个stack，一个正常存，一个做单调栈
 * 不用判空，好像没什么难点。。
 * wa了一次，发现一个小坑，有重复的数字，所以相等的数也要一起放进单调栈里。
 */
public class P0155 {
    public static void main( String[] args ) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(  minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(  minStack.top() );    // return 0
        System.out.println(  minStack.getMin() ); // return -2
    }

    static class MinStack {
        Stack<Integer> s1;
        Stack<Integer> s2;
        /** initialize your data structure here. */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push( x );
            if(s2.empty() || s2.peek() >= x)s2.push( x );
        }

        public void pop() {
            Integer now = s1.peek();
            s1.pop();
            if( now.equals( s2.peek( ) ) )s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }
}
