// Give an sorted infinite array and we need to find a target element in the infinite array.
// Navie appraoch would be to do linear search, hence in worse case it will take infinite time to solve, O(n) n = size of array.
/*
    static int search(int[] a, int x){
        int i = 0;
            while( true ){
                if( a[i] == x )return i;
                if( a[i] > x )return -1;
                i++;
            }
    }
    We keep on searching from the beginning until we find the target element and return i
    or we find gretor than target element so we return -1;

*/

   // EFFECICNET APPROACH-
//    We cant directly use binary search because high or n is very very large so we run in log(size) gaps i.e -> 2
    /*
        int search(int[] a, int x ){
            if(a[0] == x )return x;   check for the 0th index
            int i = 1; 
            while( a[i] < x ){
                i = i*2;
            }if( a[i] ==  x ) return i;

            return binarySearch(a, x, i/2 + 1, i-1);
        }
    */

// THIS ALGO IS COMMONLY KNOWN AS UNBOUNDED BINARY SEARCH.
public class _9_search_In_Infinite_Size_Array {
    
    public static void main(String[] args) {
        
    }
}
