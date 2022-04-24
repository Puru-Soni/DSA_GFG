import java.util.HashSet;

// Given an array (not sorted) we need to check if any of its contiguous subarray has sum as zero.
/* 
    EX: arr[] = {10,20,30};
        subarrays are: 10, 10 20, 10 20 30, 20 30, 30
*/
public class _6_subarray_with_zero_sum {

    // Navie approach:
    /* 
        Time - O(n*n)
        We run two loop considering all subarray beginning with each element.
    */
    public static boolean navieApp(int[] arr){
        for(int i = 0; i < arr.length; i++ ){
            int sum = 0;
            for(int j = i; j < arr.length; j++ ){
                sum += arr[j];
                if( sum == 0 )return true;
            }
        }return false;
    }
    // Efficient Solution:
    /* 
        Time - O(n)
        
        Using HashSet:
            Intialize sum = 0
            Keep track of prefix sum, in the HashSet.
            On keep adding element, at a point a subarry will have overall result as 0
            on it complete addition it will have same sum as prefix sum,
            then return true, else false.

        We can do the same using array:
            create a new array of n size to keep track of prefix sum.
            add first element, then its subarray sum.
            if traverse in new array for each time to check if the sum is same as any previous prefix sum.

            int n = arr.length;

            int sum = arr[0];
            if(sum == 0) return true;

            int[] temp = new int[n];
            temp[0] = sum;

            for(int i = 1; i < n; i++ ){
                sum += arr[i];
                for(int j = 0; j < n; j++ ){
                    if(temp[j] == sum ) return true;
                }
                temp[i] = sum; 
            }return false
    */

    static boolean effApp(int[] arr){
        HashSet<Integer> hs = new HashSet<>();
        int sum = 0;
        for(int i : arr ){
            sum += i;
            if( sum == 0 || hs.contains(sum) ) return true;
            else hs.add(sum);
        }
        return false;
    }
    /*
        WHY WE CHECK SUM == 0 ?
            In case of prefix sum is zero it will not repeat again
            i.e. ex: {-3,1,2,4}
                    -3 | 1 | 2
                    it has sum = 0; but its new for hashSet, therefore it will be ignored.
    */
    public static void main(String[] args) {
    // Test Cases:
        // int arr[] = {1,4,13,-3,-10,5};
        int arr[] = {-3,1,2,4};
        // int arr[] = {0,1,2,3,4};
    
    // Output:
        // System.out.println(navieApp(arr));
        System.out.println(effApp(arr));
    }   
}
