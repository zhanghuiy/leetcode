import java.util.LinkedList;
import java.util.List;
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();

        Stack<ArrayList> stack = new Stack<>();
        for(int i = 0; i < candidates.length; i++){
            ArrayList l = new ArrayList();
            if(target - candidates[i] >= 0){
                l.add(target - candidates[i]);
                l.add(candidates[i]);
                stack.push(l);
            }
        }
        while(!stack.isEmpty()){
            ArrayList l = (ArrayList)stack.pop();
            int remain = (Integer)l.get(0);
            if(remain == 0){
                l.remove(0);
                ret.add((List)l);
            }else if(remain > 0){
                int last_element = (Integer)l.get(l.size()-1);
                for(int i = 0; i < candidates.length; i++){
                    if(candidates[i] >= last_element && candidates[i] <= remain){
                        ArrayList new_list = (ArrayList)l.clone();
                        new_list.set(0, remain-candidates[i]);
                        new_list.add(candidates[i]);
                        stack.push(new_list);
                    }
                }
            }
        }

        return ret;
    }
}
