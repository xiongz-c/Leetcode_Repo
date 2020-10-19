class P0844{
    public static void main(String[] args) {
        
    }
    static class Solution {
        public String generatre(String str){
            StringBuilder res = new StringBuilder();
            for(int i = 0;i < str.length();i++){
                if(str.charAt(i)!='#')res.append(str.charAt(i));
                else{
                    if(res.length()==0)continue;
                    else{
                        res.delete(res.length()-1,res.length());
                    }
                }
            }
            return res.toString();
        }
        public boolean backspaceCompare(String S, String T) {
            String a = generatre(S);
            return a.equals(generatre(T));
        }
    }

}