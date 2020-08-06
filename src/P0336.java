import java.util.*;

/**
 * P0336：回文对
 * 给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
 * 又是一道做不出来的hard题参考官方题解
 *
 *
 */

public class P0336 {
    public static void main( String[] args ) {
        String[] input = new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> ans = new Solution().palindromePairs( input );
        for (List<Integer> e:ans){
            System.out.print( "[" + e.get( 0 ) + "," + e.get( 1 ) + "] " );
        }
    }
    static class Solution {
        List<String> wordsRev = new ArrayList<String>();
        Map<String, Integer> indices = new HashMap<String, Integer>();

        public List<List<Integer>> palindromePairs(String[] words) {
            int n = words.length;
            for (String word: words) {
                wordsRev.add(new StringBuffer(word).reverse().toString());
            }
            for (int i = 0; i < n; ++i) {
                indices.put(wordsRev.get(i), i);
            }

            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < n; i++) {
                String word = words[i];
                int m = words[i].length();
                if (m == 0) {
                    continue;
                }
                for (int j = 0; j <= m; j++) {
                    if (isPalindrome(word, j, m - 1)) {
                        int leftId = findWord(word, 0, j - 1);
                        if (leftId != -1 && leftId != i) {
                            ret.add( Arrays.asList(i, leftId));
                        }
                    }
                    if (j != 0 && isPalindrome(word, 0, j - 1)) {
                        int rightId = findWord(word, j, m - 1);
                        if (rightId != -1 && rightId != i) {
                            ret.add(Arrays.asList(rightId, i));
                        }
                    }
                }
            }
            return ret;
        }

        public boolean isPalindrome(String s, int left, int right) {
            int len = right - left + 1;
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(left + i) != s.charAt(right - i)) {
                    return false;
                }
            }
            return true;
        }

        public int findWord(String s, int left, int right) {
            return indices.getOrDefault(s.substring(left, right + 1), -1);
        }
    }
}
