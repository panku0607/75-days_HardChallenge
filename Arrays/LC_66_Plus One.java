package Arrays;

public class LC_66_PlusOne {
    
    public static int[] plusOne(int[] digits) {
        int n  = digits.length;

        for(int i = n-1 ; i >= 0 ; i--){
            if (digits[i] < 9) {
                 digits[i]++;

                 return digits;
            }

            digits[i] = 0;
        }

        int newNum[] = new int[n + 1];
        newNum[0] = 1;
        return newNum ;

    }

    public static void main(String[] args) {
        int digits[] = {1,9,9};
        
        int arr[] = plusOne(digits);
        for(int i =0 ; i< arr.length ; i++){
            System.out.print(arr[i] + " ");

        }
    }
}
