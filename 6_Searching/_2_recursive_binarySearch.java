// Time complexity -> O(log n)
// Space complexity -> O(log n) 

// iterative is better than recursive binary search approach.

public class _2_recursive_binarySearch {

    public static int findElement(int[] arr, int x, int low, int high){
        
        if( low > high ) 
            return -1;

        int mid = low + (high-low)/2;
            
        if( arr[mid] == x ) 
            return mid;
        else if ( arr[mid] > x ) 
            return findElement(arr, x, low, mid-1);
        else 
            return findElement(arr, x, mid+1, high);  
    }

    public static void main(String[] args) {
        int arr[] = { 10, 15, 20, 25, 30, 35 };
        int n = 6;
        int x = 15;

        int index = findElement(arr, x, 0, n-1);
        System.out.println(index + " is the index of " + x);
    }
}
