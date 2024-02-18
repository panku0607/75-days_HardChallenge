public class LC_42_TrapRain_Water {
    

    //  Soluiton 1 
    //  Time Complexity:--->  O(N^2). There are two nested loops traversing the array.
    //  Auxillary Space Complexity:--->  O(1). No extra space is required.
    public static  int trap_V1(int[] height) {
        int n = height.length;
        int trapWater = 0 ; 
        for(int i = 1 ; i< n -1; i++){

            int left = height[i];

            for (int j = 0 ; j < i; j++) {
                left = Math.max(left, height[j]);
            }


            int right = height[i];
            for(int j = i + 1 ; j < n ; j++){
                right = Math.max(right, height[j]);
            }


           
            trapWater += Math.min(left, right) - height[i];
        }

        return trapWater;

    }


    //Solution 2 
    // Time Complexity ---> O(3 * N) = O(N)
    // Auxillary Space Complexity ---> O(2 * N) = O(N)
    public static  int trap_V2(int[] height) {
        int n = height.length;
        int leftMax[] = new int[height.length];
        leftMax[0] =  height[0];
        for(int i = 1 ; i< n ; i++){
            leftMax[i] = Math.max(height[i] , leftMax[i -1]);
        }


        //  to Check the Value of LeftMax
        // for (int i = 0; i < leftMax.length; i++) {
        //     System.out.print(leftMax[i] + " ");
        // }
        // System.out.println();

        int rightMax[] = new int[height.length];
        rightMax[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ;i--){
            rightMax[i] = Math.max(height[i] , rightMax[i+1]);
        }



        //  to Check the Value of rightMax
        // for (int i = 0; i < rightMax.length; i++) {
        //     System.out.print(rightMax[i] + " ");
        // }
        // System.out.println();



        // Water Level
        
        int trapWater = 0;
        for(int i = 0 ; i< n ; i++){
            int waterLevel = Math.min(leftMax[i] , rightMax[i]) - height[i];

            trapWater += waterLevel;
        }

        return trapWater;
    }


    //   Solution 3 
    //   Time Complexity: O(N)
    //   Auxiliary Space: O(1) 
    public static int trap_V3(int height[]){
        int lp = 0;
        int rp = height.length -1 ;
        int leftMax = 0 ;
        int rightMax = 0 ;
        int trapWater = 0 ;
        while (lp <= rp) {
            
            if (height[lp] <= height[rp]) {
                    if (leftMax < height[lp]) {
                        leftMax = height[lp];
                    } else{
                        trapWater += leftMax - height[lp];
                    }
                    lp++;
            } else{
                if (rightMax < height[rp]) {
                    rightMax = height[rp];
                } else{
                    trapWater += rightMax - height[rp];
                }
                rp--;
            }
        }

        return trapWater;
    }

    public static void main(String[] args) {
        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        // Soluiton 1 
        System.out.println(trap_V1(height));
        
        
        // Soluiton 2 
        System.out.println(trap_V2(height));
        

        // Solution 3 
        System.out.println(trap_V3(height));
    }
}
