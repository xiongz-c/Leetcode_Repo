/**
 * P0124:Binary Tree Maximum Path Sum
 * 经典二叉树，求最大路径和，使用递归
 * 注意极端情况：-2，-1，-3
 * 一个leetcode的小坑：把ans初始化成最小值要在方法里做，判题的时候重复执行的只有里面的方法
 */
public class P0124 {
    public static void main( String[] args ) {

    }

    static class Solution {
        int ans;
        public int maxPathSum(TreeNode root) {
            ans = Integer.MIN_VALUE;
            maxPath(root);
            return ans;
        }

        public int maxPath(TreeNode root){
            if(root==null)return 0;
            int left = Math.max(0,maxPath(root.left));
            int right =Math.max(0,maxPath(root.right));
            ans = Math.max(left+right+root.val, ans);
            return root.val + Math.max(left, right);
        }


        public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {}
            TreeNode( int val ) {
                this.val = val;
            }
            TreeNode( int val , TreeNode left , TreeNode right ) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
    }
}
