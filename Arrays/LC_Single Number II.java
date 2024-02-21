

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC_137_SingleNumber_II {
    

    //Solution 1 
    // Time Complexity ---> O(N);
    // Auxillary Space ---> O(N)  used by HashMap ; 
     public static int singleNumber_V1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i , map.getOrDefault(i , 0)+ 1);
        }

        for(Map.Entry<Integer , Integer> key : map.entrySet()){
            if(key.getValue() == 1){
                return key.getKey();
            }
        }

        return Integer.MIN_VALUE;
    }

    //Solution 2 
    // Time Complexity ---> O(N * LogN);
    // Auxillary Space ---> O(1); 
    public static int singleNumber_V2(int nums[]){
        Arrays.sort(nums);

       for(int i = 1 ; i < nums.length ; i+= 3){
           if(nums[i] != nums[i-1] || nums[i] != nums[i+1]){
               return nums[i-1];
           }
       }

       return nums[nums.length-1];
          
        
    }

    //Solution 3 
    // Time Complexity ---> O(32 * N);
    // Auxillary Space ---> O(1); 
    public static int singleNumber_V3(int nums[]){
        
         int ans = 0 ;
        for (int i = 0; i < 32; i++) {
              int sum = 0 ;
              int BitMask = 1 << i ;
              for (int j = 0; j < nums.length; j++) {
                      
                    if ((BitMask & nums[j]) != 0) {     // ( nums[j] >> i & 1) == 1 
                        sum++;
                       
                    }
                    
              }
               sum = sum % 3;
              if (sum!= 0) {
                 ans = ans +  (sum << i);   //  instead of  (sum << i) you can Write (BitMask)
              }
        }

        return ans;
        
    }



    public static int singleNumber_V4(int nums[]){
            int ones = 0 , twos = 0 ;

            for(int i = 0 ; i< nums.length ; i++){
                ones = (ones ^ nums[i]) & (~twos);
                twos = (twos ^ nums[i]) & (~ones);
            }

            return ones ;
    }


    public static void main(String[] args) {
        int nums[] = {22,22,4,22};

        //Solution 1 
        System.out.println(singleNumber_V1(nums));

        //Solution 2 
        System.out.println(singleNumber_V2(nums));

        //Solution 3
        System.out.println(singleNumber_V3(nums));

        // Soluiton 4 
        System.out.println(singleNumber_V4(nums));

       




       
    }
}
