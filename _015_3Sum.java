import  java.util.Arrays;
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList();
        }
        LinkedList<List<Integer>> ret = new LinkedList<>();
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(!hm.containsKey(nums[i])){
                int mid = i + 1;
                int right = nums.length - 1;
                while(mid < right){
                    int sum = nums[i] + nums[mid] + nums[right];
                    if( sum == 0){
                        if( (!hm.containsKey(nums[i])) || hm.get(nums[i]) != nums[mid]){
                            hm.put(nums[i], nums[mid]);
                            ArrayList<Integer> e = new ArrayList<>(3);
                            e.add(nums[i]);
                            e.add(nums[mid]);
                            e.add(nums[right]);
                            ret.add(e);
                        }
                        mid ++;
                        right --;
                    }else if(sum < 0){
                        mid ++;
                    }else{
                        right --;
                    }
                }
            }

        }
        return ret;
    }
}
