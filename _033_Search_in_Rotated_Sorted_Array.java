public class Solution {

    // O(log n) time complexity
    public int search(int[] nums, int target) {

        // find the pivot under O(log n)
        int low = 0, high = nums.length - 1, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        //[0, low), [low, nums.length-1]
        int position = binarySearch(nums, 0, low-1, target);
        if(position != -1) return position;
        position = binarySearch(nums, low, nums.length-1, target);
        if(position != -1) return position;
        return -1;
    }


    // O(n) time complexity, the best one is under O(log n)
    public int search_2(int[] nums, int target) {
        // O(n)
        int pivot = 1;
        for(; pivot < nums.length; pivot++){
            if(nums[pivot] < nums[pivot-1])break;
        }
        pivot --;

        // Binary search in intervals [0,pivot] and (pivot, nums.length)
        int position = binarySearch(nums, 0, pivot, target);
        if(position != -1) return position;
        position = binarySearch(nums, pivot+1, nums.length-1, target);
        if(position != -1) return position;
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target){
        int low = start, high = end, mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] < target){
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
