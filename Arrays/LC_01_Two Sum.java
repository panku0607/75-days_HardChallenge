package Arrays;

import java.util.HashMap;

public class Qno_1_TwoSum {

    public static int[] twoSum_(int[] nums, int target) {

        // Solution 1 
        int len = nums.length;
        for(int i =0; i< len; i++){
            for(int j = i + 1 ; j< len; j++){
                if (nums[i] + nums[j] == target) {
                   return new  int[]  {i , j};
                   
                }
            }
        }
        return new int[0];


        // solution 2
         

        HashMap<Integer , Integer> map = new HashMap<>();

        int len = nums.length;
        for(int i = 0; i< len ; i++){
            if (map.containsKey(target - nums[i])) {
                 return new int[]{map.get(target - nums[i]), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[0];
        
    }
    

  

   public static void main(String[] args) {
    
    int nums[] = {2,3,4};
    int target = 6;
    int a[] = twoSum(nums, target);
      for(int i = 0; i< a.length ; i++){
        System.out.print(a[i] + " ");
      }

   }
}
     
