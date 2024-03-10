package Arrays;

public class LC_171_ExcelSheet_ColumnNum {
        // Solution 
        // Time Complexity --> O(n) 
        // Space Complexity ---> O(1)
        
    public static int titleToNumber(String coltitle) {
        int sum = 0;

        for(int i = 0; i<coltitle.length() ; i++){
            char ch = coltitle.charAt(i);
            sum = sum * 26 + (ch - 'A' + 1);
        }
        return sum ;
    }
    public static void main(String[] args) {
     String coltitle = "CD";
     System.out.println(titleToNumber(coltitle));
    }
}
