import java.util.Arrays;
public class _7_median_of_row_sorted {
    public static void main(String[] args) {
    // Given an odd sized matrix and every row is sorted. Find its median
        int arr[][] = { {5, 10, 20, 30, 40},
                        {1, 2, 3, 4, 6},
                        {11, 13, 15, 17, 19}};
    /* 
        arr[][] = { {5, 10, 20, 30, 40}
                    {1, 2, 3, 4, 6}
                    {11, 13, 15, 17, 19}}

        -> 1,2,3,4,5,6,10,11,13,15,17,19,20,30,40
        here 15 is median.


        // NAIVE SOLUTION:
        time complexity: O(r*c*logrc)

        -put all element of arr[r][c] int arr[r*c] matrix
        -sort the matrix
        -return the median


        // Efficient Solution:
        time complexity: O(r*log(max_el-min_el)*logc)

        ( hint )We use Binary Search.

        algo->
            We get mix out of all first el of rows 
            We get max out of all last el of rows

    */
        int max = arr[0][arr[0].length-1];
        int min = arr[0][0];
        for(int i = 1; i < arr.length; i++ ){
            if( arr[i][0] < min ) min = arr[i][0];
            if( arr[i][arr[0].length-1] > max ) max = arr[i][arr[0].length-1];
        }
        int medianPosition = ((arr.length-1)*(arr[0].length-1) + 1)/2;
        while(min < max ){
            int mid = (max+min)/2;
            int midPosi = 0;
            for(int i = 0; i < arr.length; i++ ){
                int posi = Arrays.binarySearch( arr[i], mid ) + 1;
                midPosi += Math.abs(posi);
            }
            if( midPosi < medianPosition ) min = mid+1;
            else max = mid;
        }
        System.out.println(min);
    } 
}