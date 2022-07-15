// Give an array find the max occurence of a given target element.

// Navie approach is to linear search and count as many time as the target element occures in the array.


// We use binary Search:
/*
    We get the first occurence (low) 
    and the last occurence of the target element (high), 
    and then count the total number of occurence by = high - low + 1 
*/
public class _6_cnt_Occurence_of_a_element {
    
    public static int firstOcc(int[] a, int x, int low, int high ){
        while( low <= high ){
            int mid = (low + high)/2;
            if( a[mid] > x ) high = mid-1;
            else if( a[mid] < x ) low = mid+1;
            else{
                if( mid == 0 || a[mid] != a[mid-1] ){
                    return mid;
                }else{
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static int lastOcc(int[] a, int x, int low, int high ){
        while( low <= high ){
            int mid = (low + high)/2;
            if( a[mid] > x ) high = mid-1;
            else if( a[mid] < x ) low = mid+1;
            else{
                if( mid == a.length-1 || a[mid] != a[mid+1] ){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int a[] = {10, 20, 20, 30, 30, 30, 30, 30, 40, 40};
        int x = 30;
        
        if ( firstOcc(a, x, 0, a.length-1) == -1 ){
            System.out.println(0);
            System.exit(0);
        }else System.out.println( lastOcc(a, x, 0, a.length-1) - firstOcc(a, x, 0, a.length-1) + 1 );
    }
}
