import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC_31_Next_Permutation {
   
   
    // Solution 1 
    // Time Complexity --> O(3N), where N = size of the given array
    // Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).

//  Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).
    public static List<Integer> nextPermutation_V1(List<Integer> nums) {
        // 1 Figure Out The Break Point 
        int idx = -1 ;
        int n = nums.size();
        for(int i = n-2 ; i>= 0 ; i-- ){
            if(nums.get(i) < nums.get(i + 1)){
                idx = i ;
                break;
            }
        }

        if(idx == -1){
         Collections.reverse(nums);
        }

        // 2 Find SomeOne Greater Than next and the Smallest one 
        for(int i = n -1 ; i > idx ; i--){
            if(nums.get(i) > nums.get(idx)){
                int temp = nums.get(i) ; 
                nums.set(i, nums.get(idx));
                nums.set(idx, temp);
                break;
            }
        }

        // Reverse the rermaing from the idx to nums.length;
        List<Integer> sub = nums.subList(idx+ 1, n);
       Collections.reverse(sub);
       return nums;
    }




     // Solution 2 
    // Time Complexity --> O(3N), where N = size of the given array
    // Finding the break-point, finding the next greater element, and reversal at the end takes O(N) for each, where N is the number of elements in the input array. This sums up to 3*O(N) which is approximately O(3N).

//  Space Complexity: Since no extra storage is required. Thus, its space complexity is O(1).
    public static void nextPermutation_V2(int nums[]){
        int idx = -1;
        // int idx2 = -1;
        int n = nums.length;
        for(int i = n-2 ; i >= 0 ; i--){
            if(nums[i] < nums[i + 1]){
                idx = i ;
                break ;
            }
        }
        // if there is no breaking  point
        if(idx == -1){
            reverse(nums , 0);
            return ;
        } 
    
            // step 2 find next greater element and swap with ind2
            for(int i = n-1 ; i >idx ; i--){
                if(nums[i] > nums[idx]){
                    swap(idx , i , nums);
                    break;
                }
            }
            

            reverse(nums , idx + 1 );
    }
    

    public static void reverse(int nums[] , int start){
        int i = start;
        int j  = nums.length -1 ;
        while(i < j){
            swap(i , j , nums);
            i++;
            j--;
        }
    }

    public static void swap(int i , int j , int nums[]){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        // Solution 1
        List<Integer> A = Arrays.asList(new Integer[] {1,2,3});
        List<Integer> nums =  nextPermutation_V1(A);
       
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) +" ");
        }
        System.out.println();


        // Solution 2
        int arr[] = {2,1,5,4,3,0,0};
        nextPermutation_V2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}
