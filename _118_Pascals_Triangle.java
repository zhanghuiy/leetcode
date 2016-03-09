public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> last = new ArrayList<>();
        last.add(1);
        res.add(last);
        for(int row = 1; row < numRows; row++){
            List<Integer> current = new ArrayList<>();
            for(int idx = 0; idx <= row; idx ++){
                int num = 0;
                if(idx - 1 >= 0) num += last.get(idx-1);
                if(idx <= row - 1) num += last.get(idx);
                current.add(num);
            }
            res.add(current);
            last = current;
        }
        return res;
    }
}
