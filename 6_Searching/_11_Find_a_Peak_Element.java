// We are given an unsorted array and we need to find one of the peak elements.
// Peak element is one which is larger than both of its corresponding elements.
/*
    In Case:

    First element - should be greator than its right neighbour
    Last element - should be greator than its left neighbour
    middle element - should be greator than left and right neighbour

    ex : { 20, 5 ,90 ,80 ,100 }

    here 20, 90, 100 are peak elements.

*/


// Navie solution is to check: 
/*
    -if one element than return the element.
    -if more than one
        -check for the first elements.
        -check for the last elements.
        -Run a loop 1 -> (n-1) check the middle elements.


    void getPeak(int[] a, int n){
        if( n == 1 ) return a[n-1];
        else{
            if( a[0] > a[1] ) return n[0];
            if( a[n-1] > a[n-2] ) return a[n-1];
            for( int  i = 1; i < n-1; i++ ) if( a[i] > a[i-1] && a[i] > a[i+1] ) return a[i];
    }
*/

//Efficiet approach-
/*
    O(logn) - T
    O(1) - S
    Use binary search:
        Get mid:
            if mid == 0 or mid == n-1 i.e only one element is there, then return mid.
            if a[mid] >= a[mid-1] && a[mid] >= a[mid+1] return mid element.

            else if a[mid] <= a[mid-1] high = mid-1  // it means mid is smaller than the left element i.e. left can be peak.
            else low = mid+1 // it means mid is smaller than the right element i.e. right can be peak.
*/

/**
 * PeakElement
 */
public class _11_Find_a_Peak_Element {
    public static void main(String[] args) {
        int a[] = {10, 20, 30, 55, 60, 40};
        int low = 0;
        int high = a.length-1;

        while( low <= high ){

            int mid = low + (high-low)/2;

            if(( mid == 0 || a[mid] >= a[mid-1] ) && ( mid == a.length-1 || a[mid] >= a[mid+1] )){
                System.out.println(mid);
                System.exit(0);
            }
            if( mid > 0 && a[mid] <= a[mid-1] ) high = mid-1;
            else low = mid+1;
        }
        System.out.println(-1);
    }
}
