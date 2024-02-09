package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class LC_15_3Sum {
    
     
        // Solution 1    TC ---> O(N3 * log(no. of unique triplets)), where N = size of the array.    
            //           SC ---> O(2 * no. of the unique triplets) as we are using a set data structure and a list to store the triplets.
    public static List<List<Integer>> threeSum_V1(int[] nums) {
        HashSet<List<Integer>> set  = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j +1; k < nums.length; k++) {

                        if (nums[i] + nums[j] + nums[k] == 0 ) {
                            List<Integer> list = Arrays.asList(nums[i] , nums[j] , nums[k]);
                            list.sort(null);
                            set.add(list);
                           
                        }
                }
            }
            
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans ;
        
        

    }

    // Solution 2


    // Time Complexity: O(N2 * log(no. of unique triplets)), where N = size of the array. Here, we are mainly using 3 nested loops. And inserting triplets into the set takes O(log(no. of unique triplets)) time complexity. But we are not considering the time complexity of sorting as we are just sorting 3 elements every time.


    //Space Complexity: O(2 * no. of the unique triplets) + O(N) as we are using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.

    public static List<List<Integer>> threeSum_V2(int[] nums) { 
        int n = nums.length ;
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++ ){
           Set<Integer> hashSet = new HashSet<>();
            for(int j = i +1; j < n ; j++){
                int third = -(nums[i] + nums[j]);
                if (hashSet.contains(third)) {
                    List<Integer> temp = Arrays.asList(nums[i] , nums[j] , third);
                    temp.sort(null);

                    set.add(temp);
                }
                hashSet.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }


    // solution 3 
    
    // Time Complexity: O(NlogN)+O(N2), where N = size of the array.    Reason: The pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N2). 

    // Space Complexity: O(no. of quadruplets),   This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).

 public static List<List<Integer>> threeSum_V3(int[] nums) { 
    int n = nums.length ;
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    for(int i = 0 ; i < n ; i++){
        if(i > 0 && nums[i] == nums[i -1]){
            continue;
        }
        int j = i + 1 ;
        int k = n-1 ;
        while(j < k){
            int sum = nums[i] + nums[j] + nums[k];
            if(sum < 0 ){
                j++ ;
            } else if(sum > 0){
                k-- ;
            } else{
                List<Integer> temp = Arrays.asList(nums[i] , nums[j] , nums[k]);
                ans.add(temp);
                j++ ;
                k--;
                while(j < k && nums[j] == nums[j -1]){
                    j++ ;
                }
                while(j < k && nums[k] == nums[k + 1]){
                    k-- ;
                }
            }
        }
    }
    return ans;
 }


public static void main(String[] args) {
    int[] nums = { -1, 0, 1, 2, -1, -4};
    int n = nums.length;
    List<List<Integer>> ans =  threeSum_V3(nums);
    for (List<Integer> it : ans) {
        System.out.print("[");
        for (Integer i : it) {
            System.out.print(i + " ");
        }
        System.out.print("] ");
    }
    System.out.println();

}
}
