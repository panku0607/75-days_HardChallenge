package Arrays;

import java.util.*;

public class LC_349_Intersection_Of_Two_Arrays {
    
    public static int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ls = new ArrayList<>();
        
        for(int i = 0 ; i< nums1.length ; i++){
            set.add(nums1[i]);
        }

        for(int i = 0; i< nums2.length ; i++){
            if (set.contains(nums2[i])) {
                ls.add(nums2[i]);
                set.remove(nums2[i]);
            }
           
        }
        int arr[] = new int[ls.size()];

        for(int i = 0 ; i< ls.size(); i++){
            arr[i] = ls.get(i);
        }

        return arr;
        
    }
    public static void main(String[] args) {
        int nums1[] = {4,9,5};
        int nums2[] = {9,4,9,8,4};

        int arr1[] = intersection(nums1, nums2);
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}
