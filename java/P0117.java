import java.util.LinkedList;
import java.util.Queue;
/**
 P0117:填充每一个节点的下一个右侧结点指针II
 题意：填充g给定二叉树的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
       初始状态下，所有 next 指针都被设置为 NULL。
 题解：用queue层次遍历
 */

 public class P0117{
     public static void main(String[] args) {
         
     }
        static class Node {
            public int val;
            public Node left;
            public Node right;
            public Node next;
        
            public Node() {}
            
            public Node(int _val) {
                val = _val;
            }
        
            public Node(int _val, Node _left, Node _right, Node _next) {
                val = _val;
                left = _left;
                right = _right;
                next = _next; 
            }
        };
     
    static class Solution {
         public Node connect(Node root) {
            if(root==null)return null;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                if(queue.size()>1){
                    int times = queue.size();
                    for(int i = 0;i < times;i++){
                        Node now = queue.poll();
                        if(i!=times-1)now.next = queue.element();
                        if(now.left!=null)queue.offer(now.left);
                        if(now.right!=null)queue.offer(now.right);
                    }
                }else{
                    Node now = queue.poll();
                    if(now.left!=null)queue.offer(now.left);
                    if(now.right!=null)queue.offer(now.right);
                }
                
            }
         return root;
        }
    }
}