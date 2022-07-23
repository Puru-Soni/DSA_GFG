// Given an array we need to left rotate it by 1 space.

/**
 * arrays2LeftRotateBy1
 */
public class _7_Left_Rotate_By_1_in_sorted_array {

    public static void main(String[] args) {
        int a[] = { 1,2,3,4,5,6 };
        int n = a.length;

        int temp = a[0];
        for(int i = 1 ; i < n; i++ ){
            a[i-1] = a[i];
        }
        a[n-1]  = temp;

        for( int i = 0; i < n; i++ ){
            System.out.print(a[i] + " ");
        }
    }
}