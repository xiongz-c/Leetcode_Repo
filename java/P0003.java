import java.util.LinkedList;
import java.util.Queue;

/**
 * P0003:
 * 题意：找到字符串中最长的没有重复字母的字串
 * 做法
 */

public class P0003 {
    public static void main( String[] args ) {
        String input = "abba";
        Solution sol = new Solution();
        System.out.println( sol.lengthOfLongestSubstring( input ) );
    }

    static class Solution{
        public int lengthOfLongestSubstring(String s) {
            int[] index = new int[100];
            int now = 0;
            Queue<Character> q = new LinkedList<>(  );
            char[] str = s.toCharArray();
            for (char e:str){
                if(index[e-' ']==0){
                    q.add( e );
                    index[e-' ']=1;
                    now = Math.max(now,q.size());
                }else{
                    while(true){
                        char tmp = q.remove();
                        index[tmp-' ']=0;
                        if(tmp==e)break;
                    }
                    q.add( e );
                    index[e-' ']=1;
                    now = Math.max(now,q.size());
                }
            }
            return now;
        }
    }
}
