// WE are given a sorted array and it is rotated in counter-clockwise direction in any D places.
// Also we need to find the target in logn time.


// Navie solution is to use simple linear search in the array. O(n) time

// Efficient:
/*
    We use Binary Search-
    (in binary search we skip most part of the array, normal half of it )
    we take the mid element and,
    Also one half will be sorted so we compare it to low index and high index.
    
*/
class searching10sortedRotatedArray {
    public static void main(String[] args) {
        int a[] = { 3, 1, 0 };
        int x = 0;
        
        int low = 0;
        int high = a.length-1;

        while( low <= high ){
            int mid = (low+high)/2;
            if( a[mid] == x ){
                System.out.println(mid);
                System.exit(0);
            }
            if( a[mid] > a[low] ){
                if ( a[mid] > x && a[low] <= x ) high = mid-1;
                else low = mid+1;
            }else{
                if( a[mid] < x && a[high] >= x ) low = mid+1;
                else high = mid-1;
            }
        }
        System.out.println(-1);
    }
}