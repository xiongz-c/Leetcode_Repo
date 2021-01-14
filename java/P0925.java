class P0925{
    public static void main(String[] args) {
        
    }
    static class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int j = 0;
            int len1 = name.length();
            int len2 = typed.length();
            for(int i = 0;i < len1;i++){
                if(name.charAt(i)==typed.charAt(j)){
                    j++;
                }else{
                    while(j!=0 && j!=len2 &&typed.charAt(j) == typed.charAt(j-1))j++;
                    if(j < len2 && name.charAt(i)==typed.charAt(j)){
                        j++;
                    }else{
                        return false;
                    }
                }
            }
            if(j==len2)return true;
            while(j!=0 && j!=len2 && typed.charAt(j) == typed.charAt(j-1))j++;
            return j==len2;
        }
    }
}