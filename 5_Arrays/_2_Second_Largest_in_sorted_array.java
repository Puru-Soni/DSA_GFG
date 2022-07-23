// Given an array and we need to find the second largest element in the array:

public class _2_Second_Largest_in_sorted_array {
    public static void main(String[] args) {
        int a[] = { 10, 20, 45, 5, 1, 15, 45 };
        int n = a.length;

        //  intialising result = second max and max element.
        int res = -1;
        int max = a[0];

        for( int i = 1; i < n; i++ ){
            // If we found new max, then assign old max as second max.
            // else check if new element is not duplicate of max and greator than current second max then its will be new second max.
            if( a[i] > max ){
                res = max;
                max = a[i];
            }else if( a[i] != max && a[i] > res ){
                res = a[i];
            }
        }
        System.out.println(res);
        System.exit(0);

    }
}
