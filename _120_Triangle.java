public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;
        int maxLen = triangle.get(triangle.size()-1).size();
        int[] minPath = new int[maxLen];
        for(List<Integer> row : triangle){
            Integer[] rowArray = new Integer[row.size()];
            row.toArray(rowArray);
            int rowLen = rowArray.length;
            for(int i = rowLen-1; i >= 0; i--){
                if(rowLen == 1){
                    minPath[i] = rowArray[i];
                }else{
                    int min = 0;
                    if(i == rowLen-1){
                        min = minPath[i-1] + rowArray[i];
                    }else if(i == 0){
                        min = minPath[i] + rowArray[i];
                    }else{
                        min = Math.min(minPath[i-1], minPath[i]) + rowArray[i];
                    }
                    minPath[i] = min;
                }
            }
        }
        int min = minPath[0];
        for(int i = 1; i < minPath.length; i++){
            min = Math.min(min, minPath[i]);
        }
        return min;
    }
}
