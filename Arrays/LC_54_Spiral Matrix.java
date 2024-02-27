import java.util.ArrayList;
import java.util.List;

public class LC_54_Spiral_Matrix {
    
    // Solution 1
    // Time Complexity --> O(m*n)
    // Space Complexity --> O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> list = new ArrayList<>();
         int startRow = 0 ;
        int endRow = matrix.length-1;
        int startCol = 0;
        int endCol = matrix[0].length-1;

        while (startRow <= endRow && startCol <= endCol) {
           
            // j --> column iteration
            // i --> row iteration

            //Top
            for(int j = startCol; j <= endCol ; j++){
               list.add(matrix[startRow][j]);
            }
            

            // Right
            for (int i = startRow+1; i <= endRow; i++) {
                list.add(matrix[i][endCol]);
            }


            //Bottom
            for(int j = endCol-1; j >= startCol ; j--){
                if (startRow == endRow) {
                    break;
                }
                list.add(matrix[endRow][j]);
            }


            // Left
            for(int i = endRow-1 ; i >= startRow + 1 ; i--){
                if (startCol == endCol) {
                    break;
                }
                list.add(matrix[i][startCol]);
            }

             
             startRow++;
             startCol++;
             endRow--;
             endCol--;
        }
        return list;


    }

    public static void main(String[] args) {
         int matrix[][] = {{1,2,3},
                           {4,5,6},
                           {7,8,9}};

            System.err.println(spiralOrder(matrix));
    }
}
