import java.util.HashSet;
import java.util.Set;

// We are given an unsorted array and we need to find a pair of element which statisfy the given sum.
/* 
    Array is unsorted, has negative values, duplicates. 
    ex: [3,2,8,15,-8]
        sum = 17
    o/p: true   // 15,2 
*/
public class _5_find_pair_unsorted_array {
   
/* 
    NAVIE SOLUTION:
        we run two for loop taking each element and findig its pair.
*/
    static boolean findPair(int[] arr, int sum){
        for(int i = 1; i < arr.length; i++ ){
            for(int j = i; j < arr.length; j++ ){
                if( arr[j-i] + arr[j] == sum ) return true;
            }
        }
        return false;
    }

/* 
    // Sorting technique:
        We can sort the array and use two pointer approach to find the pair for the given sum 
        time complexity: O(nlogn)
    
    Efficient Solution:
        Use hashing:
            (Wrong approach) We insert elements in Hash and for each element we check if hash.contains(sum-arr[current])
            hence this approach we also consider the same current element therefore might return wrong answer.
        
        While inserting element in to HashSet, we check before inserting into HashSet, if sum-arr[i] already exists
        if Yes we return true, else we keep adding to set, atlast if not found we return false.

        Time complexity: O(n)
        Aux Space: O(n)
*/
    static boolean effFindPair(int[] arr, int sum ){
        Set<Integer> hs = new HashSet<>();
        for(int i : arr){
            if( hs.contains(sum-i) ) return true;
            else hs.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {0,8,3,11,5,9,2};
        int sum = 9;
        // System.out.println(findPair(arr, sum));
        System.out.println(effFindPair(arr, sum));
    }
}
