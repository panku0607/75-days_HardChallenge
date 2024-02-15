package Arrays;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC_18_4_Sum {

    // Solution 1
    // TC O(n^4)
    // SC O(1)
    public static List<List<Integer>> fourSum_V1(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            list.sort(null);
                            set.add(list);
                        }
                    }

                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }



     // Solution 2 
     // Time Complexity: O(N3*log(M)), where N = size of the array, M = no. of elements in the set.
     // Reason: Here, we are mainly using 3 nested loops, and inside the loops there are some operations on the set data structure which      take log(M) time complexity.

     // Space Complexity: O(2 * no. of the quadruplets)+O(N)
     // Reason: we are using a set data structure and a list to store the quads. This results in the first term. And the second space is taken by the set data structure we are using to store the array elements. At most, the set can contain approximately all the array elements and so the space complexity is O(N).
     
     
    public static List<List<Integer>> fourSum_V2(int[] nums, int target) {

        HashSet<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                HashSet<Long> store = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    long sum = nums[i] + nums[j];
                        sum +=    nums[k];
                     long fourth = target - sum ;
                    if (store.contains(fourth)) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        list.sort(Integer :: compareTo );  // we can also Write     // list.sort(null);
                        set.add(list);
                    }
                    store.add( (long) nums[k]); 

                }
            }

        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;

    }

      //   Solution 3 
      //     Time Complexity: O(N3), where N = size of the array.
      //     Reason: Each of the pointers i and j, is running for approximately N times. And both the pointers k and l combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N3). 

    // Space Complexity: O(no. of quadruplets), This space is only used to store the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).
    public static List<List<Integer>> fourSum_V3(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>() ;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i =0 ; i <n ; i++ ){
            if (i > 0 && nums[i] == nums[i -1 ]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {

                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue ;
                }
                int k = j + 1 , l = n -1 ;
                while (k < l) {
                    long sum = nums[i] + nums[j] ;
                        sum+=  nums[k] ;
                        sum += nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++ ;
                    } else{
                        List<Integer> list = Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]);
                        list.sort(Integer :: compareTo);
                        set.add(list);
                        k++ ;
                        l-- ;

                        while (k < l && nums[k] == nums[k-1]) {
                              k++ ;
                        }
                        while (k < l && nums[l] == nums[l+1]) {
                              l--;
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        //solution 1
        List<List<Integer>> ans = fourSum_V1(nums, target);
        
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();

        // solution 2
        List<List<Integer>> ans2 = fourSum_V2(nums, target);
        for (List<Integer> it : ans2) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
        
        // solution 3 
        List<List<Integer>> ans3 = fourSum_V3(nums, target);
        for (List<Integer> it : ans3) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}
