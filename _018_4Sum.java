import java.util.Arrays;
import java.util.LinkedList;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList();
        for(LinkedList<Integer> l:kSum(nums, target, 4)){
            ret.add(new ArrayList<Integer>(l));
        }
        return ret;
    }

    public LinkedList<LinkedList<Integer>> kSum(int[] nums, int target, int k){
        if(nums.length < k){
            return new LinkedList();
        }

        Arrays.sort(nums);

        LinkedList<LinkedList<Integer>> ret = new LinkedList<LinkedList<Integer>>();

        if( k > 2 ){
            Integer prev = null;
            for(int i = 0; i <= nums.length - k; i++){
                if(prev != null && prev.equals(nums[i])){
                    continue;
                }
                prev = nums[i];
                LinkedList<LinkedList<Integer>> result = kSum(Arrays.copyOfRange(nums, i+1, nums.length), target-nums[i],k-1);
                for(LinkedList<Integer> l : result){
                    l.addFirst(nums[i]);
                    ret.add(l);
                }
            }
        }else if(k == 2){
            int left = 0;
            int right = nums.length - 1;
            Integer l_prev = null;
            Integer r_prev = null;
            int prev_step = 0;
            while( left < right){
                if(l_prev != null && r_prev != null && l_prev == nums[left] && r_prev == nums[right]){
					if(prev_step == 1){
						left++;
					}else if(prev_step == 2){
						right--;
					}else{
						left++;
						right--;
					}
					continue;
				}
				l_prev = nums[left];
				r_prev = nums[right];
                int sum = nums[left] + nums[right];
                if(sum == target){
                    LinkedList<Integer> l = new LinkedList<>();
                    l.add(nums[left]);
                    l.add(nums[right]);
                    ret.add(l);
                    left++;
                    right--;
                    prev_step = 3;
                }else if(sum < target){
                    left++;
                    prev_step = 1;
                }else{
                    right--;
                    prev_step = 2;
                }
            }
        }
        return ret;
    }
}
