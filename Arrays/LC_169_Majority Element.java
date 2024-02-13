package Arrays;

import java.util.*;
public class LC_169_Majority_Elements {
        
    
    // Solution 1 
    // TC ---> O(n* logn)  WE are sorting the element 
    public static int majorityElement_V1(int[] num) {
        int n = num.length;
        Arrays.sort(num);
        return num[n/2];
    }
  
    // Solution 2 
    // TC ---> O(n)  
    // SC ---> O(n)  AS we are using HashMap to store the value 
    public static int majorityElement_V2(int num[]){
        HashMap<Integer , Integer > map = new HashMap<>();
        int n = num.length ;
        for(int i = 0 ; i< n ; i++){
            int elmt = num[i] ;
            map.put(elmt, map.getOrDefault(elmt, 0) + 1);
        }
        

        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            if (map.get(key) > n / 2) {
                return key;
            }
        }
        return -1;
    }


     // Solution 3 
    // TC ---> O(n)  
    // SC ---> O(1)  
    public static int majorityElement_V3(int num[]){

        int major = 0; 
        int count = 0 ;

        for(int i = 0 ; i< num.length ; i++){
            if (count == 0) {
                major = num[i];
                count++;
            } else if (major == num[i]) {
                    count++;
            } else {
                count--;
            }
        }

        return major;
    }


    public static void main(String[] args) {
        int num[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElement_V1(num));
        System.out.println(majorityElement_V2(num));
        System.out.println(majorityElement_V3(num));
    }
}
