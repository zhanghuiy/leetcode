public class Solution {
    public int jump(int[] nums) {
        // greedy
        // keep scaning whole array, find the farthest it can be.
        int[] step = new int[nums.length];
        for(int i = 0; i < step.length; i++){
            step[i] = -1;
        }
        step[0] = 0;
        int start = 0, end = 0;
        while(true){
            int used = step[start];
            if(end >= nums.length - 1){
                return used;
            }
            int new_end = end;
            for(int i = start; i <= end; i++){
                if(i + nums[i] > new_end){
                    new_end = i + nums[i];
                }
            }
            if(new_end > end){
                start = end;
                end = Math.min(new_end, nums.length-1);
                for(int i = start; i <= end; i++){
                    step[i] = used + 1;
                }
            }else{
                return -1;
            }
        }
    }
}
