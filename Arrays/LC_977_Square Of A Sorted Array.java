package Arrays;

import java.util.Arrays;

public class LC_977_SquareOfA_SortedArray {
    
     public static int[] sortedSquares_V1(int[] nums) {
        int n = nums.length ;
        for(int i = 0 ; i< n ; i++){
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);
        
        return nums;
    }
    
    
    public static int[] sortedSquares_V2(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n -1;
        int res[] = new int[n];
        for(int k = n-1; k >= 0 ; k--){
            if (Math.abs(nums[i]) < Math.abs(nums[j])) {
                res[k] = nums[j] * nums[j];
                j--;
            } else{
                res[k] = nums[i] * nums[i];
                i++;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        int nums[] = {-4,-1,0,3,10};
        int arr[] = sortedSquares_V2(nums);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
