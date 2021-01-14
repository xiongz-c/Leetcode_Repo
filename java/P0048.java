public class P0048 {
    public static void main(String[] args) {
        
    }
    static class Solution {
        void swap(int[][]matrix, int i, int j,int k, int l){
            int tmp = matrix[i][j];
            matrix[i][j] = matrix[k][l];
            matrix[k][l] = tmp;
        }
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for(int i = 0; i < (n >> 1); ++i){
                for(int j = i; j < n - 1 - i; ++j){
                    swap(matrix,i,j, j,n - 1 - i);
                    swap(matrix,i,j, n - 1 - i,n - 1 - j);
                    swap(matrix,i,j, n - 1 - j,i);
                }
            }
        }
    }
}

