/**
 * lastOccur_element
 */
// Given an array and a target element we need to find if the element exits in the array, fint its last occurence in the array.

//  Navie aproach is to traverese from the right side to search for the target element in the array
// But time complexity - O(n)

// We can use binary search: 
public class _5_last_Occur_of_element {

    public static void main(String[] args) {
        int a[] = { 10, 20, 20, 30, 30, 30, 40, 50, 50, 60};
        int x = 30;
        
        int low = 0;
        int high = a.length-1;
        while( low <= high ){
            int mid = (low+high)/2;

            if( a[mid] < x ) low = mid+1;
            else if( a[mid] > x ) high = mid-1;
            else{
                if( mid == a.length-1 || a[mid] != a[mid+1] ){
                    System.out.println(mid);
                    break;
                }else{
                    low = mid+1;
                }
            }
        }
        if( low > high ) System.out.println(-1);
    }
}