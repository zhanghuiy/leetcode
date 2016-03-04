public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> result = new LinkedList<>();
        if(nums.length == 0){
            return (List)result;
        }
        List<Integer> l = new ArrayList<Integer>();
        l.add(nums[0]);
        int i = 1;
        result.add(l);
        for(; i < nums.length; i++){
            int size = result.size();
            while(size > 0){
                List l_out = result.poll();
                for(int j = 0; j <= l_out.size(); j++){
                    List l_new = new ArrayList(l_out);
                    l_new.add(j, nums[i]);
                    result.add(l_new);
                }
                size--;
            }
        }
        return (List)result;
    }
}
