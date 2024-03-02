package Arrays;

import java.util.Arrays;

public class LC_3033_ModifyTheMatrix {

    public static int[][] modifiedMatrix(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int j = 0; j < col; j++) {
            int max = Integer.MIN_VALUE;
            
            for (int i = 0; i < row; i++) {
                max = Math.max(max, matrix[i][j]);
                
            }

            for (int i = 0; i < row; i++) {
                if(matrix[i][j] == -1){
                    matrix[i][j] = max;
                }
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, -1 }, { 4, -1, 6 } , {7,8,9}};

        int ans[][] = modifiedMatrix(matrix);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                 System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
