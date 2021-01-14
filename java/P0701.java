/**
 * P0701:二叉搜索树中的插入操作
 * 题意：给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 
 * 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 * 题解：
 */

 class P0701{
    public static void main(String[] args) {
         
     }
    static class TreeNode {
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
 
    static class Solution{
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if(root==null)return new TreeNode(val);
            TreeNode head = root;
            TreeNode prev = null;
            while(root!=null){
                prev = root;
                if(root.val < val){
                    root = root.right;
                }else if(root.val > val){
                    root = root.left;
                }
            }
            if(val < prev.val)prev.left = new TreeNode(val);
            else if(val > prev.val)prev.right = new TreeNode(val);
            return head;
        }
     }
 }