import java.util.HashMap;
import java.util.Map;

// Given an binary array ( contains 0 / 1 only ) and we need to find the longest subarray which conatins equal no of zero and ones. 

public class _9_long_subarray_with_num_of_0or1 {

    // Naive Approach:
    /* 
        Time - O(n*n)
        Space - O(1)

        Initialize res = 0 and 1's count, 0's count as 0
        We run two for loops considering each subarrays
            counting no of 1 and 0
            if count is same update the result
    */
    static int navieApp(int[] arr){
        int res = 0;
        for(int i = 0; i < arr.length; i++ ){
            int _0s = 0;
            int _1s = 0;
            for(int j = i; j < arr.length; j++ ){
                if(arr[j] == 0 ) _0s++;
                else _1s++;
                if(_1s == _0s) res = Math.max(res, _0s*2);
            }
        }
        return res;
    }
    // Eff Solution
    /*  
        Time - theta(n)
        Space - O(n)

        We can convert 0's to -1.
        This becomes longest subarray with given sum where given sum = 0          
    */
    static int effApproach(int[] arr){
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0, maxLen = 0;
        int n = arr.length;
        for(int i = 0; i < n; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0) maxLen = i+1;
            if( hm.containsKey(sum + n) ) maxLen = Math.max( maxLen, i - hm.get(sum + n) );
            else hm.put(sum + n, i);
        }return maxLen;
    }
    /*        
        ex: {1,0,1,1,0,0,1}
        convert: { 1, -1, 1, 1 ,-1, -1, 1 }

            sum sum+n   contains?   add?

        0    1   7       no          7,0
        1    0   6       no          6,1      sum == 0 : len = i+1 = 2 
        2    1   7       yes         -        ( len < i - get(7) ) = 2 < 2-0 false
        3    2   8       no          8,3
        4    1   7       yes         -        ( len < i - get(7) ) = 2 < 4-0 true, len = 4
        5    0   6       yes         -        ( len < i - get(6) ) = 4 < 5-1
        6    1   7       yes         -        ( len < i - get(7) ) = 4 < 6-0 true, len = 6      
    */
    public static void main(String[] args){
        // int arr[] = {1,0,1,1,0,0,1};
        // int arr[] = { 1,1,1,1};
        // int arr[] = { 0,0,1,1,1,1,1,0 };
        int arr[] = {0,0,1,0,1,1};
        // System.out.println(navieApp(arr));
        System.out.println(effApproach(arr));
    }
}
