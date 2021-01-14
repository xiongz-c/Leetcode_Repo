package week205;

public class P5509 {
    public static void main( String[] args ) {

    }
    static class Solution {
        public int minCost(String s, int[] cost) {
            if(s.length() < 2)return 0;
            int ans = 0;
            int len = s.length();
            char[] chars = s.toCharArray();
            for (int i = 0;i < len;i++){
                char now = chars[i];
                int max = cost[i],sum = cost[i];
                while(i + 1 < len && chars[i+1] == now){
                    sum += cost[++i];
                    max = Math.max( max,cost[i] );
                }
                if(sum != max) ans += sum - max;
            }
            return ans;
        }
    }

}
