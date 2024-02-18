package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LC_260_Single_No_III {
    

    // Solution 1 
    // Time Complexity : --> O(N)
    // Auxillary Space :---> O(N)
     public static  int[] singleNumber_V1(int[] nums) {
        int arr[] = new int[2];
        int j = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(Map.Entry<Integer , Integer> key : map.entrySet()){
            if (key.getValue()==1) {
                arr[j] = key.getKey();
                j++;
            }
        }

        return arr;
    }


    public static int[] singleNumber_V2(int nums[]){

        int xor = 0 ;
        for(int i : nums){
            xor ^= i ;
        }

        int BitMask = xor & (-xor);
            int first = 0;
        for(int i : nums){
            if ((BitMask & i) != 0 ) {
               first ^= i ;
            } 
        }

       int second = xor ^ first;

        return new int[]{first , second};
    }

    // Solution 2 
    // Time Complexity : --> O(N)
    // Auxillary Space :---> O(1)
    public static void main(String[] args) {
        int nums[] = {0,1};

        int arr1[] = singleNumber_V1(nums);

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        // Solution 2
        int arr2[] = singleNumber_V2(nums);

        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

        

        
    }
}
