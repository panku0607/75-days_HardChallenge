package Arrays;

public class LC_11_containerWithMostWater {



    //  Solution 1          TC -> O(n^2)  SC --> O(1)
    public static int maxArea_V1(int[] height) {   
        int maxWater = 0; 
        int storedWAter = 0;
        int n = height.length;
        for(int i =0; i<n ; i++ ){
            for(int j = i + 1 ; j < n ; j++){
                int h = Math.min(height[i], height[j]);
                int width = j - i ;
                 storedWAter = h * width;

               maxWater =   Math.max(storedWAter, maxWater);
               
            }
           
        }
        


         return maxWater ;
    }

    // Solution 2  TC--> O(n)  SC --> O(1)
    public static int maxArea_V2(int[] height) {
        int lp = 0; 
        int rp = height.length -1;

        int storedWAter = 0; 
        int maxWater = 0;

        while (lp != rp) {
            int h = Math.min(height[lp], height[rp]);
            int width = rp - lp ;

            storedWAter = width * h ;
            maxWater = Math.max(maxWater, storedWAter);

            if (height[lp] < height[rp]) {
                lp++;
            } else{
                rp--;
            }
        }
        return maxWater;
    }
    




    public static void main(String[] args) {
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea_V2(height));

    }
}
