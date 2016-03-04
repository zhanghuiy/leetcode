public class Solution {

    public List<List<Integer>> combine(int n, int k) {
        // return combineRecursive(n, k);
        return combineIterative(n, k);
    }


    // recursive DFS
    private List<List<Integer>> combineRecursive(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k == 0) return result;
        combineRecursiveHelper(new ArrayList<Integer>(), n , k, result);
        return result;
    }
    private void combineRecursiveHelper(List<Integer> list, int n, int k, List<List<Integer>> result) {
        if(k == list.size()){
            List<Integer> ele = new ArrayList<Integer>(list);
            result.add(ele); // copy
        }else{
            int last = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1;
            for(int append = last; append <= n; append++){
                list.add(append);
                combineRecursiveHelper(list, n, k, result);
                list.remove(list.size() - 1);
            }
        }
    }

    // iterative DFS
    private List<List<Integer>> combineIterative(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(k==0) return result;
        LinkedList<List<Integer>> stack = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            List<Integer> ele = new ArrayList<>();
            ele.add(i);
            stack.push(ele);
        }
        while(!stack.isEmpty()){
            List<Integer> ele = stack.pop();
            if(ele.size() == k) result.add(ele);
            else{
                int last = ele.get(ele.size()-1) + 1;
                for(int i = last; i <= n; i++){
                    List<Integer> newEle = new ArrayList<>(ele);
                    newEle.add(i);
                    stack.push(newEle);
                }
            }
        }
        return result;
    }
}
