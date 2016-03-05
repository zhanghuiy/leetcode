public class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] > nums[low]){
                // left partition
                if(nums[mid] < target){
                    low = mid + 1;
                }else{ // nums[mid] > target
                    if(nums[low] <= target){
                        high = mid - 1;
                    }else{
                        low = mid + 1;
                    }
                }
            }else if(nums[mid] < nums[low]){
                // right partition
                if(nums[mid] < target){
                    if(nums[high] >= target){
                        low = mid + 1;
                    }else{
                        high = mid - 1;
                    }
                }else{ // nums[mid] > target
                    high = mid - 1;
                }
            }else{
                // nums[mid] == nums[low]
                // discard nums[low], because nums[mid] has the same value.
                // the worst time complexity could be O(n)
                low ++;
            }
        }
        return false;
    }
}
