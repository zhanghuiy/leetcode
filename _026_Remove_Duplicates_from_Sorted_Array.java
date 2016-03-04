public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        int slow = 1;
        int prev = nums[0];
        for(int fast = 1; fast < nums.length; fast++){
            if(nums[fast] != prev){
                if(slow != fast){
                    nums[slow] = nums[fast];
                }
                prev = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
