import java.util.ArrayList;
import java.util.List;

public class LC_46_Permutation {

    // Solution 1 
    // Time complexity --> (n! * n)
    // Space Complexity ---> O(n)
    public static void recurPermute_V1(List<List<Integer>> ans , List<Integer> temp , int nums[] , boolean vis[] ){
        // base case 
        if(temp.size() == nums.length){
        ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(!vis[i]){
                vis[i] = true ;
                temp.add(nums[i]);
                recurPermute_V1(ans, temp, nums, vis);
                temp.remove(temp.size()-1);
                vis[i] = false ;
            }
        }
    }




    // solution 2
    // Time Complexity --> O(n! * n);
    // Space Complexity --> O(1);
    public static  void recurPermute_V2(int index , int nums[] , List<List<Integer>> ans){
        // base case 
        if(index == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i = 0 ; i < nums.length ; i++){
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index ; i < nums.length ; i++){
            swap(i , index , nums);
            recurPermute_V2(index + 1 , nums , ans );
            swap(i , index , nums);
        }
    }

    public static void swap(int i , int j , int nums[]){
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }


    // solution 3
    // Time Complexity --> O(n! * n);
    // Space Complexity --> O(1);
    public static void recurPermute_V3(List<List<Integer>> result , List<Integer> temp , int nums[]){
        // Base Case 
        if (temp.size() == nums.length) {
            
            result.add(new ArrayList<>(temp));
            return ;
        }



        for (int i = 0; i < nums.length; i++) {

            if (temp.contains(nums[i])) {
                continue ;
            }

            temp.add(nums[i]);
            
            recurPermute_V3(result, temp, nums);

            temp.remove(temp.size()-1);
        }

    }
    public static void main(String[] args) {
        int[] nums = {1,2,3};

         // solution 1

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean vis[] = new boolean[nums.length];
    recurPermute_V1(ans , temp , nums , vis);

    for (List<Integer> it : ans) {
        System.out.print("[");
        for (Integer i : it) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
    System.out.println();

    
    
    // solution 2
    
    List<List<Integer>> ans2 = new ArrayList<>();
    recurPermute_V2(0, nums, ans2);

    for (List<Integer> it : ans2) {
        System.out.print("[");
        for (Integer i : it) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
    System.out.println();

    
    
    // solution 3
    
    List<List<Integer>> ans3 = new ArrayList<>();
    recurPermute_V3(ans3, new ArrayList<>(), nums);

    for (List<Integer> it : ans3) {
        System.out.print("[");
        for (Integer i : it) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
    System.out.println();

    }
}
