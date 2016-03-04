public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0  || n == 0){
            return 0;
        }
        int[][] pathArray = new int[m][n];

        pathArray[0][0] = 1;
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                int paths = 0;
                if(row - 1 >= 0){
                    paths += pathArray[row-1][col];
                }
                if(col - 1 >= 0){
                    paths += pathArray[row][col-1];
                }
                pathArray[row][col] += paths;
            }
        }

        return pathArray[m-1][n-1];
    }
}
