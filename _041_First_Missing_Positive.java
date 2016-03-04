public class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] > 0 && nums[i] < nums.length+1){
                if(nums[i] != i+1){
                    if(nums[i] == nums[nums[i] - 1]){
                        nums[nums[i] - 1] = 0;
                    }
                    int tmp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = tmp;
                }
            }else{
                nums[i] = 0;
            }
            if(nums[i] == 0 || nums[i] == i+1)i++;
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                return i + 1;
            }
        }
        return nums.length+1;
    }
}
