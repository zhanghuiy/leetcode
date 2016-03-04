public class Solution {
    public boolean canJump(int[] nums) {
        int start = 0, end = 0;
        while(true){
            if(end >= nums.length - 1){
                return true;
            }
            int extend = end;
            for(int i = start; i <= end; i++){
                extend = Math.max(extend, nums[i] + i);
            }
            if(extend <= end){
                return false;
            }else{
                start = end;
                end = extend;
            }

        }
    }
}
