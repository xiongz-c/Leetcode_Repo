/**
 * P0968:监控二叉树
 * 题意：选定n个节点，每个节点可以覆盖其父子节点，求最小的n把整个二叉树全覆盖。
 * 题解：递归。
 * 约定一个状态的描述：当前节点为root，子节点为left和right，这个节点的状态可以有以下三种，
 * a. root 必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
 * b. 覆盖整棵树需要的摄像头数目，无论 root 是否放置摄像头。
 * c. 覆盖整棵树需要的摄像头数目，无论 root 是否放置摄像头
 * 可以很容易得到求解a和b的方程：
 * a = l.c+r.c+1
 * b = min(a,min(l.a+r.b,l.b+r.a))
 * c = min(a,l.b+r.b)
 * 注意在root为null时应给一个极大的a，让b的转移方程中的右半部分不可能存在。
 */
public class P0968 {
    public static void main( String[] args ) {

    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){this.val = val;}
    }
    static class Solution{
        public int[] dfs(TreeNode root){
            if(root == null){
                return new int[]{Integer.MAX_VALUE/2,0,0};
            }
            int[] leftStatus = dfs( root.left );
            int[] rightStatus = dfs( root.right );
            return new int[]{leftStatus[2] + rightStatus[2] +1,
                    Math.min( leftStatus[2] + rightStatus[2] +1,Math.min( leftStatus[0]+rightStatus[1], leftStatus[1]+rightStatus[0] ) ),
                    Math.min( leftStatus[2] + rightStatus[2] +1, leftStatus[1] + rightStatus[1] )};
        }
        public int minCameraCover(TreeNode root) {
            int[] ans = dfs( root );
            return ans[1];
        }
    }
}
