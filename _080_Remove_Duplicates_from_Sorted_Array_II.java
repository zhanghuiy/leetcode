public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 2, fast = 2;
        for( ; fast < nums.length; fast++){
            if(nums[fast] > nums[slow-2]){
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        return slow;
    }
}
