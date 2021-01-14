/**
 * P0543:Diameter of Binary Tree
 * 题意：求树的的直径
 * 做法：DSAA写过板子，就是两次dfs
 * 但是！这里没有提供回溯，所以只能用传统方法了
 */
public class P0543 {
    public static void main( String[] args ) {

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
    //需要返回两个变量，用一个node存一下好一点
    static class Pair{
        int height,diameter;
        Pair(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }
    static class Solution {

        public Pair dfs( TreeNode root ) {
            if(root == null)return new Pair( 0,0 );
            Pair left = dfs( root.left );
            Pair right = dfs( root.right );
            int nowHeight = Math.max( left.height,right.height )+1;
            int nowDiameter = Math.max( left.diameter,Math.max( right.diameter,left.height+right.height));
            return new Pair( nowHeight,nowDiameter );
        }

        public int diameterOfBinaryTree( TreeNode root ) {
            return dfs( root ).diameter;
        }
    }
}
