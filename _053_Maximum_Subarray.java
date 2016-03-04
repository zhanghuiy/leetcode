public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] max = new int[nums.length];
        max[0] = nums[0];
        for(int i = 1; i < max.length; i++){
            max[i] = Math.max(max[i-1]+nums[i], nums[i]);
        }
        int res = max[0];
        for(int i = 1; i < max.length; i++){
            res = Math.max(res, max[i]);
        }
        return res;
    }
    // public int maxSubArray(int[] nums) {
    //     int maxSoFar=nums[0], maxEndingHere=nums[0];
    //     for (int i=1;i<nums.length;++i){
    //         maxEndingHere= Math.max(maxEndingHere+nums[i],nums[i]);
    //         maxSoFar=Math.max(maxSoFar, maxEndingHere);
    //     }
    //     return maxSoFar;
    // }
}
