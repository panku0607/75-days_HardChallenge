


import java.util.*;

public class LC_136_SingleNumber {
    

    // Solution 1 
    // Time Complexity ---->O(n);
    // Auxilarry Space ----> O(n) = O(n); 
    public static  int singleNumber_V1(int[] nums) {
      
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i< nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        if (entry.getValue() == 1) {
            return entry.getKey();
        }
    }
    return -1;
    }


    // Solution 2 
    // Time Complexity ---->O(N*logN);
    // Auxilarry Space ----> O(1)

    public static int singleNumber_V2(int nums[]){

        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i+= 2){
            if (nums[i] != nums[i-1]) {
                return nums[i-1];
            }
        }

        return nums[nums.length-1];
        
    }

    // Solution 3 
    // Time Complexity ---->O(N);
    // Auxilarry Space ----> O(1)
    public static int singleNumber_V3(int nums[]) {
        int ans = 0 ;
        for(int i : nums){
            ans = ans ^ i ;
        }
        return ans;
    }


    



    public static void main(String[] args) {
        int nums[] = {4,1,2,1,2};

        //Solution 1
        System.out.println(singleNumber_V1(nums));

        // Solution 2
        System.out.println(singleNumber_V2(nums));

        //Solution 3 
        System.out.println(singleNumber_V3(nums));

        


        System.out.println(1^2);
        
    }




}
