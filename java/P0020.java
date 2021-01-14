/**
 * P0020: 有效的括号
 * 题意：给定大中小括号，返回括号序列合法性
 * 题解：联系deque栈使用
 */
import java.util.*;

 class P0020{
     public static void main(String[] args) {
         System.out.println(new Solution().isValid("{[]}"));
     }
     static class Solution{
        public boolean isValid(String s) {
            char[] items = s.toCharArray();
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0;i < items.length;i++){
                if(stack.isEmpty()){
                    stack.push(items[i]);
                    continue;
                }
                if(stack.peek() + 1 == items[i] || stack.peek() + 2 == items[i]){
                    stack.pop();
                }else{
                    if(stack.peek() < items[i])return false;
                    stack.push(items[i]);
                }
            }
            return stack.isEmpty();
        }
     }
 }