/**
 * P0977:有序数组的平方
 * 题意：给定一个有序数组，返回平方后的有序数组
 * 题解：负数平方后顺序会变，比较优的做法是当成两个数组，相当于merge两个有序数组，只需要O（n）
 * 诡异的是比之前先算再sort时间没什么变化，可能是new太费时间了
 */

class P0977{
    static  class Solution{
        public int[] sortedSquares(int[] A) {
            int[] B = new int[A.length];
            int idx = -1;
            for(int i = 0;i < A.length;i++){
                if(i!=A.length-1 && A[i]*A[i+1] <= 0){
                    idx = i;
                    break;
                }
            }
            if(idx==-1){
                if(A[0] >= 0){
                    for(int i = 0;i < A.length;i++){
                       B[i] = A[i]*A[i];
                    }
                }else{
                    for(int i = 0;i < A.length;i++){
                        B[i] = A[A.length-i-1]*A[A.length-i-1];
                    }
                }
                return B;
            }
            int[]a1 = new int[idx+1];
            int[]a2 = new int[A.length - (idx+1)];
            for(int i = 0;i < idx+1;i++){
                a1[i] = A[idx-i]*A[idx-i];
            }
            for(int i = idx+1;i < A.length;i++){
                a2[i-idx-1] = A[i]*A[i];
            }            
            int i = 0;int j = 0;int k = 0;
            while(i < idx+1 && j < A.length - (idx+1)){
                if(a1[i] < a2[j]){
                    B[k++] = a1[i++];
                }else{
                    B[k++] = a2[j++];
                }
            }
            while(i < idx+1 ){
                B[k++] = a1[i++];
            }
            while(j < A.length - (idx+1)){
                B[k++] = a2[j++];
            }
    
            return B;
        }
    }
}