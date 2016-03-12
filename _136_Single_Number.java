public class Solution {
    public int singleNumber(int[] nums) {
        // xor
        int result = 0;
        for(int num : nums){
            result ^= num;
        }
        return result;
    }
}
