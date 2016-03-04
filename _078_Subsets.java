public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // []
        // [], | [nums[0]] <- add nums[0]
        // [], [nums[0]], | [nums[1]], [nums[0], [nums1]] <- add nums[1]
        // [], [nums[0]], [nums[1]], [nums[0], [nums1]] | ...... <- add nums[2]
        // the size of the result is doubled in each step.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>()); // add []
        for(int num : nums){
            int prevSize = res.size();
            for(int i = 0; i < prevSize; i++){
                List<Integer> newEle = new ArrayList<>(res.get(i)); // create a new list
                newEle.add(num);
                res.add(newEle);
            }
        }
        return res;
    }
}
