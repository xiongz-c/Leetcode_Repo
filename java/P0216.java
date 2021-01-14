import java.util.ArrayList;
import java.util.List;

public class P0216 {
    public static void main( String[] args ) {
        System.out.println( new Solution().combinationSum3( 3,2 ) );
    }

    static class Solution {
        List<List<Integer>> ans = new ArrayList<List<Integer>>( );
        List<Integer> sequence = new ArrayList<Integer>( );

        public List<List<Integer>> combinationSum3( int k , int n ) {
            if ( k > 9 || n > 45 ) return new ArrayList<List<Integer>>( );
            dfs( 1, n , k );
            return ans;
        }

        public void dfs( int pos , int rest,int k ) {
            if ( rest == 0 && k ==0) {//达到要求
                ans.add( new ArrayList<Integer>( sequence ) );
                return;
            }
            if ( pos > 9 || rest < pos ) {//不可能达到要求了
                return;
            }
            dfs( pos + 1 , rest ,k);
            sequence.add( pos );
            dfs( pos + 1 , rest - pos,k-1 );
            sequence.remove( sequence.size( ) - 1 );
        }
    }
}
