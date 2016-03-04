public class Solution {
    private void swapInts(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
    public void sortColors(int[] nums) {
        int pZero = 0;
        int pTwo = nums.length - 1;
        for(int i = 0; i <= pTwo; i++){
            if(nums[i] == 0){
                if(pZero != i) swapInts(nums, i, pZero);
                pZero ++;
            }else if(nums[i] == 2){
                if(pTwo != i){
                    swapInts(nums, i, pTwo);
                    i --;
                }
                pTwo --;
            }
        }
    }
}
