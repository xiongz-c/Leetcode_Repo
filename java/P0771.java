import java.util.HashMap;
import java.util.Map;

/**
 * P0771. 宝石与石头 题意：给定字符串J和S，判断S中含有多少个J中的字符 题解：暴力做法O（mn），打表，然后用hash表读取可以做到O（m+n）
 * J存hash集合，O1判断；或者S存哈希表；
 */

 class P0771{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int numJewelsInStones(String J, String S) {
            int ans = 0;
            Map<Character,Integer> map = new HashMap<>();
            for(int i = 0;i < S.length();i++){
                char c = S.charAt(i);
                if(map.containsKey(c))map.replace(c,map.get(c)+1);
                else map.put(c,1);
            }
            for(int i = 0;i < J.length();i++){
                if(map.containsKey(J.charAt(i)))ans += map.get(J.charAt(i));
            }
            return ans;
        }
    }
 }