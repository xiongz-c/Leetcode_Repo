class P1002{
    public static void main(String[] args) {
        
    }
    static class Solution {
        public List<String> commonChars(String[] A) {
            List<String> ans = new ArrayList<>();
            int len = A.length;
            int[][] counter = new int[len][60];
            for(int i = 0;i < len;i++){
                for(int j = 0;j < A[i].length();j++){
                    counter[i][A[i].charAt(j)-'A']++;
                }
            }
            for(int i = 0;i < 60;i++){
                int minValue = Integer.MAX_VALUE;
                for(int j = 0;j < len;j++){
                    minValue = Math.min(counter[j][i],minValue);
                }
                if(minValue > 0){
                    for(int j = 0;j < minValue;j++){
                        ans.add(String.valueOf((char)(i+'A')));
                    }
                }
            }
            return ans;
        }
    }
}