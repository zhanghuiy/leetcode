public class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;
        while(nums[mid] != target){
            int prev_mid = mid;
            if(nums[mid] < target){
                left = mid + 1;
                mid = (left + right)/2;
            }else{
                right = mid - 1;
                mid = (left + right)/2;
            }
            if(mid == prev_mid){
                break;
            }
        }
        return target <= nums[mid] ? mid : mid + 1;
    }
}
