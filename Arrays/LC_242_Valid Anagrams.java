package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;;

public class LC_242_Valid_Anagram {

    // Solution 1
    // TC --> O(n*logn); we are doing Sorting which takes O(n*logn )
    // Sc ---> O(n);

    public static boolean isAnagram_V1(String s, String t) {
        char arr1[] = s.toCharArray();
        char arr2[] = t.toCharArray();

        if (s.length() != t.length()) {
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (arr1[i] != arr2[j]) {
                return false;
            } else {
                i++;
                j++;
            }
        }

        return true;

    }

    // Solution 2
    // TC --- > O(n)
    // SC ---> O(s + t)
    public static boolean isAnagram_V2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (map.get(ch) != null) {

                if (map.get(ch) == 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0) - 1);
                }
            }

        }

        return map.isEmpty();

    }

    // Solution 3 
    // Time Complexity ---> O(n)
    // Auxillary Space ---> O(n)
    public static boolean isAnagram_V3(String s , String t){
        int alphabet[] = new int[26];
        for(int i = 0 ; i<s.length() ; i++){
            alphabet[s.charAt(i) - 'a'] ++ ;
        }

        for(char i = 0 ; i < t.length() ; i++){
            alphabet[t.charAt(i) - 'a'] -- ;
        }

        for(int i : alphabet){
            if (i != 0) {
                return false ;
            }
        }

        return true; 
    }
    public static void main(String[] args) {
        String s = "accc";
        String t = "ccac";

        // Solution 1
        System.out.println(isAnagram_V1(s, t));

        // Solution 2
        System.out.println(isAnagram_V2(s, t));

        // Solution 3
        System.out.println(isAnagram_V3(s, t));
    }
}
