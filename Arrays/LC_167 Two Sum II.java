
package Arrays;

 class LC_167_TwoSum_2 {

    public static int[] twoSum(int[] numbers, int target) {
        int lp = 0 , rp = numbers.length -1;
        while (lp != rp) {
            if (numbers[lp] + numbers[rp]== target) {
                return new  int[]  {lp + 1 , rp + 1};
                 }
            else if (numbers[lp] + numbers[rp] < target) {
                    lp++;
            } else{
                rp--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
            int numbers[] = {2,7,11,15};
            int target = 9;
            int arr[] = twoSum(numbers, target);
            for(int i = 0 ; i< arr.length ; i++){
                 System.out.print(arr[i] + " ");
            }
    }
}
