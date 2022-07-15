/**
 * firstOccur_element
 */

//  Give an sorted array and a target elment we need to find the first occurrence of the element.

// Navie Approach would be to do linear search of O(n) TIME.
/*
    int[] arr = {10, 20, 20, 30, 30, 40};
    int x = 30;

    for( int i =0; i < n; i++ ){
        if(arr[i] == x )
            System.out.print( i );
        else continue;    
    }

    But we need efficient approach and we use BINARY SEARCHING:
*/

// USING RECURSIVE BINARY SEARCH: O(logn) T & S.
// public class firstOccur_element {

//     public static int recursive_bs(int[] a, int x, int low, int high ){
//         if( low > high ) return -1;

//         int mid = (low+high)/2;

//         if( a[mid] > x ) return recursive_bs(a, x, low, mid-1);
//         else if( a[mid] < x ) return recursive_bs(a, x, mid+1, high);

//         // Same of before just one change
//         // IF we found element we check if the index is 0 then return else if last index and it is unqiue then return.
//         // If found and not statisfy the first condition we go in the left part of it low -> mid-1.

//         else{
//             if( mid == 0 || a[mid] != a[mid-1] ){
//                 return mid;
//             } return recursive_bs(a, x, low, mid-1);
//         }
//     }
//     public static void main(String[] args) {
//         int a[] = { 10, 20, 20, 30, 30, 30, 40, 50, 50, 60};
//         int x = 30;
//         int index = recursive_bs(a, x, 0, a.length-1);
//         System.out.println(index + " of element " + x);
//     }
// }

/**
 * firstOccur_element
 **/

// ITERATIVE BINARY SEARCH:
// O(logn) - T
// O(1) - S
public class _4_firstOccur_element {

    public static void main(String[] args) {
        int a[] = { 10, 20, 20, 30, 30, 30, 40, 50, 50, 60 };
        int x = 30;

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] < x)
                low = mid + 1;
            else if (a[mid] > x)
                high = mid - 1;
            else {
                if (mid == 0 || a[mid] != a[mid - 1]) {
                    System.out.println(mid);
                    break;
                } else {
                    high = mid - 1;
                }
            }
        }

        if (low > high)
            System.out.println(-1);
    }
}