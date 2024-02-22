import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC_219_Contains_Duplicate_II {

    public static boolean containsNearbyDuplicate_V1(int[] nums, int k) {
     // Solution  1 
    // Time Complexity :---> O(N ^ 2)_C
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
