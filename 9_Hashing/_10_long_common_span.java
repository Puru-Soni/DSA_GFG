import java.util.HashMap;

/* 
    Given two binary arrays of same size
    We need to find out length of common subarray
    Such that sum of elements is same in both
    also start and ending index in both subarray should be same
*/
/* 
    EX:
    i/p : { 0,1,0,0,0,0 }
          { 1,0,1,0,0,1 }
              -------
    o/p : 4
*/
public class _10_long_common_span {

    /* 
    NAVIE SOLUTION:
        O(n*n)

        Both array have same size-
        we run a loop for every elements:
            inner loop to traverse to every subarray starting with every element
            we track sum of both array starting with same index
            if at any point sum is same we get the max length
        return resulting max subarray length with equal sum and starting at same index
    */
    static int navieMthd(int[] a, int[] b){
        int res = -1;
        for(int i = 0; i < a.length; i++ ){
            int suma = 0, sumb = 0;
            for(int j = i; j < a.length; j++ ){
                suma += a[j]; sumb += b[j];
                if( suma == sumb ) res = Math.max(res, j-i+1);
            }
        }return res;
    }
    /* 
        We get a difference of both the subarray:
            temp array = each element of array1 - element of array2
    */
    static int effMthd(int[] a, int[] b){
        int res = -1;
        int n = a.length;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++ ) temp[i] = a[i] - b[i]; 
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < n; i++ ){
            sum += temp[i];
            if( sum == 0 ) res = i + 1;
            if ( hm.containsKey(sum) ) res = Math.max(res, i - hm.get(sum));
            else hm.put(sum, i);
        }return res;
    }
    /* 
        a[] =  0  1  0  1  1  1  1
        b[] =  1  1  1  1  1  0  1
     temp[] = -1  0 -1  0  0  1  0

    i    sum    if sum == 0? containes? = sum   add?    res
    -    0                                               -
    0    -1         no         no               -1,0     -1
    1    -1         no         yes              no       -1 or 1 - 0 : res = 1
    2    -2         no         no               -2,2      1
    3    -2         no         yes              no        1 or 3 - 2 : res = 1
    4    -2         no         yes              no        1 or 4 - 2 : res = 2
    5    -1         no         yes              no        2 or 5 - 0 : res = 5
    6    -1         no         yes              no        4 or 6 - 0 : res = 6

    */
    public static void main(String[] args) {
        int arr[] = { 0,1,0,0,0,0 };
        int brr[] = { 1,0,1,0,0,1 };
        
        // int[] arr = {0, 1, 0, 1, 1, 1, 1}; 
		// int[] brr = {1, 1, 1, 1, 1, 0, 1};
        
        // int arr[] = { 0,0,0 };
        // int brr[] = { 1,1,1 };

        // System.out.println(navieMthd(arr,brr));
        System.out.println(effMthd(arr,brr));
    }
}
