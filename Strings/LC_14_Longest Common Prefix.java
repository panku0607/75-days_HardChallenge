import java.util.Arrays;

public class LC_14_Longest_Common_Prefix {
    
    // Solutuion 1 
    // Time Complexity :---> O (N log n ).   Arrays.sort takes O(n log n) time complexity, where n is the number of strings in the array.
    // Space Complexitu :---> O(n + m )

    public static String longestCommonPrefix_V1(String[] strs) {
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        StringBuilder ans = new StringBuilder("");
        for(int i = 0 ; i< first.length ; i++){
            if (first[i] != last[i]) {
                break;
            }

            ans.append(first[i]);
        }

        return ans.toString();

    }



    // Solutuion 2 
    // Time Complexity :---> O ( m * N).  where m is the length of the prefix and n is the number of strings in the input array. 
    // Space Complexitu :---> O(m)

    public static String longestCommonPrefix_V2(String[] strs) {

        int n = strs.length;
        String ans = strs[0];

        for(int i =0 ; i< n ; i++){
            while (strs[i].indexOf(ans) != 0) {
                   
                ans = ans.substring(0 , ans.length()-1);

                if(ans.isEmpty()){
                    return "";
                }
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        

        String[] strs = {"clue" , "club " , "cluster" , "clutch" , "clutcher"};

        //Solution 1 
        System.out.println(longestCommonPrefix_V1(strs));

        // Solution 2 
        System.out.println(longestCommonPrefix_V2(strs));

    }
}
