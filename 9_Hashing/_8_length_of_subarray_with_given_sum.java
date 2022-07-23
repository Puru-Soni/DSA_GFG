import java.util.HashMap;
import java.util.Map;

// Given an array we need to find the length of max subarray length which add up to a given sum.
public class _8_length_of_subarray_with_given_sum {
    
    // NAVIE SOLUTION:
    /* 
        Time - O(n*n)
        Aux Space - O(1)

        // given array as arr and given sum as x.

        intitalize res = 0 and curr_count = 0;
        Run two for loops:
        initialze sum = 0
        i = 0 -> n
        initialze sum = 0
            and j = i to n
                if( sum < x )
                    sum = sum + arr[j]
                    curr_count increments.
                if( sum == x )
                    break loop.
            get max of res, curr_count
        print res.    
    */  
    static int navieCount(int[] arr, int sum ){
        int res = 0;
        for(int i = 0; i < arr.length; i++ ){
            int add = 0;
            for(int j = i; j < arr.length; j++ ){
                add += arr[j];
                if(add == sum ){
                    res = Math.max(res, j-i+1);
                    break;
                } 
            }
        }return res;
    }    
    // Efficient Solution:
    /* 
        Time  - theta(n)
        Aux Space - O(n)
        We initialize presum and res = 0
        Run a loop form i = 0 to arr of length
            we caculate presum by adding each element
            check if presum is same as given sum, then res = i+1
            check if presum does not already exists snice we dont want to update the value ( index of each presum )
                if not add the presum as key in hashMap
                else conitnue
            check if presum-sum already occured i.e. a subaarray with sum = given sum exists then,
                we get length from curr index i to value of presum-sum key
                get the max of old res and new subarray length
        RETURN RESULTING SUBARRAY LENGTH
    */    
    static int effCount(int[] arr, int sum){
        Map<Integer, Integer> hs = new HashMap<>();
        int presum = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++ ){
            presum += arr[i];
            if ( presum == sum ) res = i+1;
            if( !hs.containsKey(presum) ) hs.put(presum, i);
            if( hs.containsKey(presum-sum) ){
                res = Math.max( res, i-hs.get(presum-sum) );
            }
        }return res;
    } 
    
    public static void main(String[] args) {
        // int[] arr = { 5,8,-4,-4,9,-2,2 }; int sum = 0;
        // int[] arr = { 3,1,0,1,8,2,3,6}; int sum = 5;
        // int[] arr = {8,3,7}; int sum = 15;
        int[] arr = { 8,3,1,5,-6,6,2,2 }; int sum = 4;
        /* 
            presum presum-sum contains?

        0    8,0      8-4         no
        1    11,1     11-4        no
        2    12,2     12-4        yes, 8 ( 3 + 1 ) res = i-0 = 2
        3    17,3     17-4        no
        -    11       11-4        no  // the key, value pair will not be updated.
        -    17       17-4        no  // the key, value pair will not be updated.
        6    19,6     19-4        no
        7    21,7     21-4        yes, 17 ( -6 + 6 + 2 + 2 ) res = max of ( 2, i-3 = 4 ) = 4    
            
        */

        // System.out.println(navieCount(arr, sum));
        System.out.println(effCount(arr, sum));
    }   
}
