import java.util.Arrays;
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }

        int closest = 0;
        Integer distance = null;

        if(nums.length < 3){
            for(int i = 0; i < nums.length; i++){
                closest += nums[i];
            }
            return closest;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            int mid = i + 1;
            int right = nums.length - 1;
            while(mid < right){
                int sum = nums[i] + nums[mid] + nums[right];
                int d = Math.abs( sum - target);
                if(distance == null || d < distance ){
                    distance = d;
                    closest = sum;
                }
                if(sum < target){
                    mid ++;
                }else if(sum > target){
                    right --;
                }else{
                    return sum;
                }

            }
        }

        return closest;

    }
}
