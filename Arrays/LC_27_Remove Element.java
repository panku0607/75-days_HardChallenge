package Arrays;

public class Qno_27_removeElement {
    
    public static int removeElement(int[] nums, int val) {

        int j = 0;
        
        int len = nums.length ;

        for(int i =0 ; i < len ; i++){
            if (nums[i] == val) {
                 continue;
            } else{
                nums[j] = nums[i];
            }
            j++ ;
        }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        return j;
    }
    public static void main(String[] args) {
        int nums[] = {0,1,2,2,3,0,4,2};
        int val = 2 ;

        System.out.println(removeElement(nums, val));
    }
}
