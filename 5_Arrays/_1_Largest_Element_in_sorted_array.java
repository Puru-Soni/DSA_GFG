// We are given an integer array and we need to find the largest element in the array with O(n) time
public class _1_Largest_Element_in_sorted_array {
    public static void main(String[] args) {
        int a[] = { 10, 50, 5, 15, 45, 1, 12 };
        int n = a.length;

        // intitalise first element as largest, then compare it to next ->
        int res = a[0];
        for( int i = 1; i < n; i++ ){
            // If greator element found then current we update the result.
            if ( a[i] > res ){
                res = a[i];
            }
        }
        System.out.println(res);
    }
}
