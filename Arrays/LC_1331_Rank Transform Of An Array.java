import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

public class LC_1331_Rank_TansformOfAnArray {
    

    // Solution 1 
    // Time Complexity -->  O(NlogN)
   //   Space  Complexity -- >  O(N)
     public static int[] arrayRankTransform_V1(int[] arr) {
        int nums[] = Arrays.copyOf(arr , arr.length);
        Arrays.sort(nums);

        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i : nums){
            map.putIfAbsent(i, map.size() + 1);
            
        }
       

        for(int i = 0 ; i< arr.length ; i++){
            nums[i] = map.get(arr[i]);
        }

        return nums;
}


    // Solution 2
    //Time complexity: O(nlogn) - TreeSet formation (Nlogn) + Only tranversing the array O(N)
    //Space complexity:O(n)
public static int[] arrayRankTransform_V2(int[] arr) {
    Set<Integer> set  = new TreeSet<>();
    
    for(int i : arr){
        set.add(i);
    }

    int nums[] = new int[arr.length];
    HashMap<Integer, Integer> map = new HashMap<>();
    int rank = 1 ;
    for(int i : set){
        map.put(i, rank++);
    }

    

    return nums;

}
    public static void main(String[] args) {
        
        int arr[] = {37,12,28,9,100,56,80,5,12};

        // Solution 1 
        int a [] = arrayRankTransform_V1(arr);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();


        //solution 2
        int a1 [] = arrayRankTransform_V1(arr);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();


       
    }
}
