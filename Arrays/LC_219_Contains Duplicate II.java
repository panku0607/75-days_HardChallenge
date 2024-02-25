import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_219_Contains_Duplicate_II {

    public static boolean containsNearbyDuplicate_V1(int[] nums, int k) {
     // Solution  1 
    // Time Complexity :---> O(N ^ 2)
    // Space Complexity :---> O(1)
        int  n = nums.length ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if (nums[i] == nums[j] && i != j) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Solution  2 
    // Time Complexity :---> O(N)
    // Space Complexity :---> O(N)
    public static boolean containsNearbyDuplicate_V2(int nums[] , int k){
        HashMap<Integer , Integer > map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i ) <= k) {
                        return true ;
                }
            }

            map.put(nums[i], i);
        }

            return false;
        
    }


    // We can also do it using Sliding Window
    // Solution  3 
    // Time Complexity :---> O(n)
    // Space Complexity :---> O(n)
    public static boolean containsNearbyDuplicate_V3(int nums[] , int k){
        int i =0 ,j = 0;
         HashSet<Integer> set = new HashSet<>();
         int n = nums.length;
        while (j<n) {
            // Step 1
            if (Math.abs(i - j) > k) {
                 set.remove(nums[i]);
                 i++;
            }  

            // Step 2
            if (set.contains(nums[j])) {
                    return true;
            }

            set.add(nums[i]);
            j++;
        }

        return false;
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        int k = 3;

        // Solution 1 
        System.out.println(containsNearbyDuplicate_V1(nums, k));

        // Solution  2
        System.out.println(containsNearbyDuplicate_V2(nums, k));

        // Solution 3
        System.out.println(containsNearbyDuplicate_V3(nums, k));

    }
}
