public static  int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int trans[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                trans[i][j] = matrix[j][i];
            }
        }
        return trans;
    }


public static void main(String args[]){
int matrix[][] = {{1,2,3},{4,5,6}};
  int ans[][] = transpose(matrix);

        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
}
