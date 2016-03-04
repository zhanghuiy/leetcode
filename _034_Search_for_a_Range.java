public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = {-1,-1};
        int min, max, tmp;
        min = searchValue(nums, 0, nums.length-1 , target);
        max = min;
        tmp = min;
        while(tmp != -1){
            tmp = searchValue(nums, 0, min - 1, target);
            if(tmp != -1 ){
                min = tmp;
            }
        }
        if(min == -1){
            return ret;
        }
        tmp = max;
        while(tmp != -1){
            tmp = searchValue(nums, max+1,nums.length-1, target);
            if(tmp != -1 ){
                max = tmp;
            }
        }
        ret[0] = min;
        ret[1] = max;
        return ret;
    }

    public int searchValue(int[] nums, int left, int right, int target){
        // returns the position of target value in the array
        if(left > right){
            return -1;
        }
        if(left == right){
            if(nums[left] == target){
                return left;
            }else{
                return -1;
            }
        }
        int len = right - left;
        int mid = left + len/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid] < target){
            return searchValue(nums, mid+1, right, target);
        }else{
            return searchValue(nums, left, mid-1, target);
        }

    }
}
