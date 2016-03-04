public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;

        // solution 3 using O(1) space
        boolean firstRow = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        firstRow = true;
                    }else{
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
        }
        for(int i = 1; i < n; i++){
            if(matrix[0][i] == 0){
                for(int j = 1; j < m; j++){
                    matrix[j][i] = 0;
                }
            }
        }
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j = 1; j < n; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int i = 1; i < m; i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRow == true){
            for(int i = 0; i < n; i++){
                matrix[0][i] = 0;
            }
        }

        // solution 2 using m+n space
        // int[] row = new int[m];
        // int[] col = new int[n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(matrix[i][j] == 0){
        //             row[i] = 1;
        //             col[j] = 1;
        //         }
        //     }
        // }
        // for(int i = 0; i < m; i++){
        //     if(row[i] == 1){
        //         for(int j = 0; j< n; j++){
        //             matrix[i][j] = 0;
        //         }
        //     }
        // }
        // for(int i = 0; i < n; i++){
        //     if(col[i] == 1){
        //         for(int j = 0; j< m; j++){
        //             matrix[j][i] = 0;
        //         }
        //     }
        // }

        // solution 1 using m*n space
        // int[][] dup = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(matrix[i][j] == 0){
        //             dup[i][j] = 1;
        //         }
        //     }
        // }
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(dup[i][j] == 1){
        //             for(int k = 0; k < n; k++){
        //                 matrix[i][k] = 0;
        //             }
        //             for(int k = 0; k < m; k++){
        //                 matrix[k][j] = 0;
        //             }
        //         }
        //     }
        // }
    }
}
