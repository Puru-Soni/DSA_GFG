import java.util.HashSet;

// We are given an array of numbers and task is to find all distinct elements.
/* 
    ex: [15, 12 ,13 , 12, 12 , 12, 13, 13, 18]
    ans: 4 (15,12,13,18)


    NAVIE APPROACH: 
        O(n*n);
        run two loops: i to n-1 and inner as j to i
        we check for every i-th if there is duplicate of i-th in that sub sequence
        if yes we continue for next i
        else if distinct we add it to distinct element count.


    Efficient Approach:
        Use hashSet
        Time complex - O(n)
        Aux Space - O(n)
*/
public class _1_count_distinct_el {
    public static void main(String[] args) {
        int[] arr = { 10,20,10,20,30 };
        HashSet<Integer> hs = new HashSet<>();

        // If we had parameter of Integer class array as Integer arr _ we can directly convert it into hashset by passing it 
        // in the constructor.   HashSet<Integer> hs = new HashSet<>(Arrays.asList(arr));

        for(int i = 0; i < arr.length; i++ )
            hs.add(arr[i]);
        System.out.println(hs);
    }
}
