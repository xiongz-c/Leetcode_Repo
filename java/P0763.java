/**
 * P0763:划分字母区间
 * 题意：字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 * 题解：
 */
class P0763{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public List<Integer> partitionLabels(String S) {
            List<Integer> ans = new ArrayList<>();
            int[] lastIndex = new int[26];
            int strLen = S.length();
            for(int i =0;i<strLen;i++){
                lastIndex[(int)(S.charAt(i) - 'a')] = i;
            }
            int now = 0,i = 0;
            while(now < strLen){
                int nowlen = 0;
                int j = lastIndex[(int)(S.charAt(i) - 'a')];
                while(i <= j){
                    j = Math.max(j,lastIndex[(int)(S.charAt(i) - 'a')]);
                    nowlen++;
                    i++;
                    now++;
                }
                ans.add(nowlen);
            }
           return ans;
        }
    }
}