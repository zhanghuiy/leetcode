import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ans = new LinkedList<>();
        Arrays.sort(candidates);
        ArrayList<Integer> candidates_list = new ArrayList();
        for(int i = 0; i < candidates.length; i++){
            candidates_list.add(candidates[i]);
        }
        dfs(candidates_list, ans, target, new LinkedList<>());
        return ans;

    }
    public void dfs(ArrayList candidates, List<List<Integer>>ans, int remains, List<Integer>list){
        if(remains == 0){
            ans.add(list);
        }else if(remains > 0){

            Integer last = -1;
            if(list.size() > 0){
                last = list.get(list.size()-1);
            }
            Integer prev = null;

            for(int i = 0; i < candidates.size(); i++){
                int e = (Integer)candidates.get(i);

                if((prev == null || prev != e) && e >= last &&e <= remains){
                    List l = new LinkedList(list);
                    l.add(e);
                    ArrayList new_candidates = (ArrayList) candidates.clone();
                    new_candidates.remove(i);

                    for(int j = 0; j < new_candidates.size(); j++){
                        if((Integer)new_candidates.get(j) < e){
                            new_candidates.remove(j);
                            j--;
                        }
                    }

                    dfs(new_candidates, ans, remains-e, l);
                }
                prev = e;
            }
        }
    }
}
