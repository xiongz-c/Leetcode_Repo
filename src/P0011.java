/**
 * P0011:盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 题解：弱智题，最快的做法是双指针，O（n）
 */

class P0011{
    public static void main(String[] args) {
        
    }
    static class Solution{
        public int maxArea(int[] height) {
            int maxArea = -1;
            int left = 0,right = height.length - 1;
            while(left < right){
                int tmp = Math.min(height[left],height[right])*(right-left);
                maxArea = Math.max(maxArea,tmp);
                if(height[left] <= height[right])left++;
                else right--;
            }
            return maxArea;
        }
    }
}