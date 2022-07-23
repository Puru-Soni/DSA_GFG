import java.util.HashSet;

// Given two unsorted arrays which might contains duplicates, we need find the intersection of both these arrays. 
/*  
    EX: [10, 5, 20, 5, 30]
        [30,5,30]
    o/p: 2
*/

public class _3_intersection_of_arrays {

/* 
    NAVIE SOLUTION:

    We traverse to the array with each element:
        -we check it is already appared or done with or already seen.
        -if yes then we continue.
        -else if not we check if it also exits in other array.
            -if yes we increment the count.

    return count.
*/
    static void navieApp(int[] arr1, int[] arr2){
        int res = 0;
        for(int i = 0; i < arr1.length; i++ ){
            boolean chk = false;
            for(int j = 0; j < i; j++ ){
                if( arr1[i] == arr1[j] ){
                    chk = true;
                    break;
                }
            }
            if( chk == true ) continue;

            for (int element : arr2) {
                if( arr1[i] == element ){ 
                    ++res;
                    break;
                }    
            }
        }System.out.println(res);
    }

/* 
    Efficient Approach:
        Insert all element of arr1 in new HashSet h1 with no duplicates
        Same for arr2 in h2.
        we check for each element of h1 in h2 and return count.
        Or use retainAll() which return true if the set changes on retaining.
        retainAll changes the x_set.retainAll(y_Set) x_set to only elements of intersection in x_set and y_set.
*/

    static void efficApp(int[] arr1, int[] arr2){
        HashSet<Integer> h1 = new HashSet<>();
        HashSet<Integer> h2 = new HashSet<>();
        for(int i : arr1){
            h1.add(i);
        }
        for(int i : arr2 ){
            h2.add(i);
        }
        // int res = 0;
        // for( int i : h2 ){
        //     if( h1.contains(i) ) res++;
        // }return res;

        h1.retainAll(h2);
        System.out.println(h1);
    }

    /* 
        Above approach provides: O(arr1.length) + O(arr2.length) + O(h1.size) time complexity.
        Hence we can change it to only O(arr1.length or arr2.length);
            We make HashSet for one of the array.
            Traverse throught another array for each element we check if it exsits in hashSet, if yes we keep removing it.
    */

    static void moreOptimize(int[] arr1, int[] arr2){
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr1){
            hs.add(i);
        }
        int count=0;
        for(int i : arr2 ){
            if( hs.contains(i) ){
                count++;
                hs.remove(i);
            }
        }System.out.println(count);
    }
    public static void main(String[] args) {
        int arr1[] = {10,5,20,5,30};
        int arr2[] = {30,5,30};
        
        // navieApp(arr1, arr2);
        // efficApp(arr1, arr2);
        moreOptimize(arr1, arr2);
    }
}
