// Given an array we need to check if it is sorted.

/**
 * arrays3CheckIfSorted
 */
public class _3_Check_If_array_is_Sorted {

    public static void main(String[] args) {
        int a[] = { 10, 20, 30, 40, 50, 60 };
        int n = a.length;

        if( n == 1 ){
            System.out.println("True, array sorted!");
            System.exit(0);
        }

        for( int i = 1; i < n; i++ ){
            if( a[i-1] > a[i] ){
                System.out.println("Fasle, not sorted!");
                System.exit(0);
            }
        }
        System.out.println("True, array sorted!");
    }
}