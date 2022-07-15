// Time Complexity = O (log n)
// Space = O(1) iterative space

class _1_iterative_binarySearch{
    public static void main(String[] args) {
        // In binary Search we are given an sorted array and we need to find a give target element index in the array.
        // For Example:
        int[] arr = { 5, 10, 15, 25, 35 };
        int target = 10;
        int n = arr.length;
        // Navie approach would be to search in linear method, n( size of array ) number of comparisions. We are not using advantage of sorting here.
        
        // We implemenet iterative binary search approach only for sorted array. Using Two pointer approach.
        // intitalizing low and high:
        int low = 0;
        int high = n-1;

        // loop until low is less than or equal to high.
        while( low <= high ){
            int mid = low + (high-low)/2;
            if( arr[mid] == target ){
                System.out.println(mid + " index of " + target + " is found!");
                break;
            }else if( arr[mid] < target ){
                low = mid + 1; 
            }else high = mid - 1;
        }
        if( low > high ) System.out.println(-1 + " not found!");
    }
}

        //  DRY RUN:
        /*
            { 5, 10, 15, 25, 35 }
            x = 10;
            n = 5;

        1   low = 0; high = 4;

            0 <= 4 true
                mid = 0 + 4/2 = 2
                arr[2] = 15
                    15 == 10 false
                    15 < 10 false
                    15 > 10 true 
                        high = 2-1 = 1;

        2   low = 0; high 1;
        
            0 <= 1 true
                mid = 0 + 1/2 = 0;
                arr[0] = 5
                    5 == 10 fasle
                    5 < 10 true 
                        low = mid+1 = 1;

        3   low = 1; high = 1;
            
            1 <= 1 true
                mid = 1 + 1-1/2 = 1;
                arr[1] = 10;
                10 == 10 true
                    return index '1'  <- FOUND


        in case x = 2 not in the array:
                10 == 2 false
                10 < 2 false
                else -> high = mid-1 = 0;

                low= 1; high = 0;
                low <= high false 
                while loop exits

                -1 NOT FOUND
        */
