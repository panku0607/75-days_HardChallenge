package Arrays;

public class LC_661_Image_Smoother {

    // Approach-1 (Using simple for loops)
    // Time Complexity : O(m*n)
    // Space Complexity : O(m*n)

    public static int[][] imageSmoother_V1(int[][] img) {
        int directions[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 0 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
                { 1, 1 } };

        int m = img.length;
        int n = img[0].length;

        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int count = 0;
                int gridSum = 0;

                for (int dir[] : directions) {
                    int nRow = i + dir[0];
                    int nCol = j + dir[1];
                    if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n) {
                        gridSum += img[nRow][nCol];
                        count++;
                    }

                }
                ans[i][j] = gridSum / count;
            }
        }

        return ans;

    }

    
    // Time Complexity : O(m*n)
    // Space Complexity : O(n)
    public static int[][] imageSmoother_V2(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        int temp[] = new int[n];
        int topCorner = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Bottom neighbour
                int sum = 0;
                int count = 0;
                if (i + 1 < m) {

                    sum += img[i + 1][j];
                    count++;

                    if (j - 1 >= 0) {
                        sum += img[i + 1][j - 1];
                        count++;
                    }
                    

                    if (j + 1 < n) {
                        sum += img[i + 1][j + 1];
                        count++;
                    }
                }

                // Right NeightNours

                if (j + 1 < n) {
                    sum += img[i][j + 1];
                    count++;
                }

                // Current cell
                    sum += img[i][j];
                    count++;


                // Left Neighbour  [i][j-1]
                if (j-1 >= 0) {
                    sum += temp[j-1];
                    count++;
                }

                // Top neighbour 
                if (i -1 >= 0) {
                    // [i-1][j-1] -> PrevCorner
                     if (j-1 >= 0) {
                        sum += topCorner;
                        count++;
                    }

                    sum += temp[j];
                    count++;

                    if (j +1 < n) {
                        sum += temp[j+1];
                        count++;
                    }
                }
                if (i-1 >= 0) {
                    topCorner = temp[j];
                }
                    
                // Current Value of [i][j]
                temp[j] = img[i][j];


                img[i][j] = sum/count;
            }
        }
        return img;
    }

    public static void main(String[] args) {
        int img[][] = { { 100, 200, 100 }, { 200, 50, 200 }, { 100, 200, 100 } };

        int ans[][] = imageSmoother_V1(img);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        int ans2[][] = imageSmoother_V2(img);
        for (int i = 0; i < ans2.length; i++) {
            for (int j = 0; j < ans2[0].length; j++) {
                System.out.print(ans2[i][j] + " ");
            }
            System.out.println();
        }
    }
}
