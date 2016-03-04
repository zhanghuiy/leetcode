public class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        int trapped = 0;
        while(left < right){
            leftMax = height[left] > leftMax ? height[left] : leftMax;
            rightMax = height[right] > rightMax ? height[right] : rightMax;
            trapped += leftMax > rightMax ? rightMax - height[right--]  : leftMax - height[left++];
        }
        return trapped;
    }
}
