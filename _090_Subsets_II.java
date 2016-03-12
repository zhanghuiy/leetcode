public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        LinkedList<Integer> remains = new LinkedList<>();
        Arrays.sort(nums);

        return subsetsWithDupHelper(new LinkedList<Integer>(), nums, 0, res);
    }

    private List<List<Integer>> subsetsWithDupHelper(LinkedList<Integer> list, int[] nums, int from, List<List<Integer>> res){
        res.add(new ArrayList<Integer>(list));
        if(from == nums.length) return res;
        Integer prev = null;
        while(from < nums.length){
            if(prev == null || prev != nums[from]){
                prev = nums[from];
                list.addLast(nums[from]);
                subsetsWithDupHelper(list, nums, from + 1, res);
                list.removeLast();
            }
            from ++;
        }
        return res;
    }
}
