/**
 * P0100：相同的树
 * 判断给出的的两棵树是不是一样
 * 遍历就好了
 */
public class P0100 {
    public static void main( String[] args ) {

    }
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null)return true;
            else if (p==null || q==null )return false;
            else{
                if(p.val!=q.val)return false;
                else{
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                }
            }
        }
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

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
