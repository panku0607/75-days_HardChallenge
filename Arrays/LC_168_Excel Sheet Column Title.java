package Arrays;

public class LC_168_Excel_Sheet_Colums_Title {
    

    // // Solution 
    // Time Complexity --> O(logN)   --- > log to the base 26 ;
    // Space Complexity ---> O(1)
    public static String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder("");
        
        while (columnNumber > 0) {
             columnNumber -- ;
             int rem = columnNumber % 26;
             str.append((char) (rem + 'A'));
             columnNumber /= 26 ;
        }

        return str.reverse().toString();
    }
    public static void main(String[] args) {
        int columnNumber = 82;

        System.out.print(convertToTitle(columnNumber));


       
    }
}
