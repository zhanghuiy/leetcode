public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] pathsArray = new int[rows][cols];
        pathsArray[0][0] = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1){
                    pathsArray[i][j] = 0;
                }else{
                    int addPaths = 0;
                    if(i - 1 >= 0){
                        addPaths += pathsArray[i-1][j];
                    }
                    if(j - 1 >= 0){
                        addPaths += pathsArray[i][j-1];
                    }
                    pathsArray[i][j] += addPaths;
                }
            }
        }
        return pathsArray[rows-1][cols-1];
    }
}
