package Arrays;

public class LC_283_MoveZeroes {


    // Solution 1 
    // TC ---> O(n)
    // SC ---> O(1)
    public static void moveZeroes_V1(int[] nums) {
        int j = 0; 
        for(int i = 0 ; i< nums.length ; i++){
            
            if(nums[i] == 0){
                j++ ;
            }
            else if(j > 0){
                int temp = nums[i];
                nums[i] = nums[i-j];
                nums[i - j] = temp;
                
            }
        }
    }
        // Solution 2 
        // TC ---> O(n)
        // SC ---> O(1)
        public static void moveZeroes_V2(int[] nums) {
        int j = 0; 
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            
            if(nums[i] != 0){
                nums[j++] = nums[i];
            }
    
        }

        while(j < nums.length){
            nums[j++] = 0;
        }
    }
    

    public static void main(String[] args) {
        int nums[] = {0,2,8,0,1,3};
        
         moveZeroes_V2(nums);
         for(int i = 0; i< nums.length ; i++){
            System.out.print(nums[i] + " ");
         }
    }
}
