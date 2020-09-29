import java.util.ArrayDeque;
/**
 * P0145:二叉树后序遍历
 * 题意：见题目
 * 题解：不要用递归，练习循环迭代的做法
 */

 public class P0145 {
     public static void main(String[] args) {
         
     }
     
     static class Solution{
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if(root==null)return ans;
            Deque<TreeNode> stack = new ArrayDeque<>();
            TreeNode prevLeft = null;
            while(root!=null || !stack.isEmpty()){
                while(root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(root.right == null || root.right == prevLeft){
                    ans.add(root.val);
                    prevLeft = root;
                    root = null;
                }else{
                    stack.push(root);
                    root = root.right;
                }
            }
            return ans;
        }
     }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
 }