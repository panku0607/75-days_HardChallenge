package Arrays;
    import java.util.Arrays;
    import java.util.Collection;
public class LC_455_Assign_Cookies {

    // solution 1
    public static  int findContentChildren_V1(int[] g, int[] s) {
        int n = g.length , m = s.length;
        int i  = 0, j = 0 , count  = 0;
        Arrays.sort(g);
        Arrays.sort(s);

        while (i < n && j < m) {
            if (g[i] <= s[j]) {
                count++ ; i++ ; j++ ;
            } else{
                j++;
            }
        }
        return count ;
    }
    // Solution 2
    public static  int findContentChildren_V2(int[] g, int[] s) {
        int n = g.length , m = s.length;
        int i =0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int j = 0 ; i < n && j < m ; j++){
                if(g[i]<= s[j]){
                    i++;
                }
        }
        return i ;
    }


    public static void main(String[] args) {
        int g[] = {9,8,7,6};
        int s[] = {6,7,8,9};
        System.out.println(findContentChildren_V1(g, s));
        System.out.println(findContentChildren_V2(g, s));

    }
}
