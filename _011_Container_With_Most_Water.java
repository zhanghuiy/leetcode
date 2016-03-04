public class Solution {
    public int maxArea(int[] height) {

        // ==== brute force ====

        // int maxArea = 0;

        // if( height.length < 2 ){
        //     return maxArea;
        // }

        // for(int index1 = 0; index1 < height.length - 1; index1++){
        //     int right_high = 0;
        //     for(int index2 = height.length - 1; index2 > index1 ; index2--){
        //         if(height[index2] > right_high){
        //             right_high = height[index2];
        //             maxArea = Math.max(maxArea, (index2 - index1) * Math.min(height[index1], height[index2]) );
        //         }
        //     }
        // }

        // return maxArea;

        // ==== brute force ====

        // ==== greedy algorithm ====

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int min_height = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max( maxArea, min_height * width);
            if(height[left] < height[right]){
                left ++;
            }else{
                right --;
            }
        }
        return maxArea;

        // ==== greedy algorithm ====
    }
}
