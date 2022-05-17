import java.util.HashSet;

// Given an array which can contains negatives, zeros etc.
// We need to find if a subarray exists with the given sum. 


public class _7_subarray_with_given_sum {
    /* 
        NAVIE APROACH:
            Run two loops and check every subarray begin with every element.
    */
    static boolean navieApp(int[] arr, int sum ){
        for(int i = 0; i < arr.length; i++ ){
            int chk = 0;
            for(int j = i; j < arr.length; j++ ){
                chk += arr[j];
                if( chk == sum ) return true;
            }
        }
        return false;
    }

    /* 
        Efficient Approach:

        Time - O(n)
        Aux Space - O(n)
        
            intitalize a empty HashSet to store the prefix sum.
            We calculate prefix sum from the first element.
            Keep adding the prefix sum to the hashSet if not equal to given sum.
            Also we check if prefix sum - given sum already seen.
                
                ex: {5,8,6,13,3,-1}
                sum = 22;
                    hs.contains(5-22) || 5-22 == 0 ? true :
                        store 5      5
                        store 5+8    13
                        store 5+8+6  19
                        store 5+8+6+13 32 
                    On 5+8+6+13+3-22 = 19 which is true for hs.contain(prefixsum - sum) 
    */

    static boolean effiApp(int[] arr, int sum){
        HashSet<Integer> hs = new HashSet<>();
        int pre_sum = 0;
        for(int i : arr ){
            pre_sum += i;
            if( pre_sum == sum || hs.contains(pre_sum-sum) ) return true;
            else hs.add(pre_sum);
        }
        return false;
    }
    public static void main(String[] args) {
        // int arr[] = {5,8,6,13,3,-1};
        // int arr[] = {15,2,8,10,-5,-8,6};
        int arr[] = {3,2,5,6};
        int sum = 5;
        
        // System.out.println(navieApp(arr,sum));
        System.out.println(effiApp(arr, sum));
    }
}
