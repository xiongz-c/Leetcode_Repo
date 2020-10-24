/**
 * P1024: 视频拼接
 * 题意：给一个为二维数组，每个子数组[a,b]表示一个区间，这个区间可以切割，求最少用多少个子数组可以覆盖[0,T]
 * 题解：暴力dp轮番遍历 / 贪心会快一些
 */
class P1024{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int videoStitching(int[][] clips, int T) {
           int[] maxn = new int[T];
           int last = 0, res = 0, pre = 0;
           for(int[] clip : clips){
               if(clip[0] < T){
                   maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1]);
               }
           }
           for(int i = 0;i < T;i++){
               last = Math.max(last, maxn[i]);
               if(i == last)return -1;
               if(i == pre){
                   res++;
                   pre = last;
               }
           }
           return res;
        }
    }
}