import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class p0857 {
    public static void main( String[] args ) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode( int x ) {
            val = x;
        }
    }

    static class Solution {
        List<String> dfs( TreeNode now , ArrayList<TreeNode> parent , List<String> ans ) {
            if(now==null)return new ArrayList<>(  );
            if ( now.left == null && now.right == null ) {
                StringBuilder now_ans = new StringBuilder( );
                for (TreeNode e : parent) {
                    now_ans.append( e.val ).append( "->" );
                }
                now_ans.append( now.val );
                ans.add( now_ans.toString( ) );
            } else {
                parent.add( now );
                if ( now.left != null && now.right != null ) {
                    dfs( now.left , parent , ans );
                    dfs( now.right , parent , ans );
                } else if ( now.left != null ) {
                    dfs( now.left , parent , ans );
                } else if ( now.right != null ) {
                    dfs( now.right , parent , ans );
                }
                parent.remove( now );
            }
            return ans;
        }

        public List<String> binaryTreePaths( TreeNode root ) {
            ArrayList<TreeNode> parent = new ArrayList<>(  );
            List<String> ans = new ArrayList<>(  );
            return dfs( root , parent, ans);
        }
    }
}
