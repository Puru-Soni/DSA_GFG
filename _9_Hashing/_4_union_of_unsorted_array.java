import java.util.HashSet;

// Given two unsorted array we need to find all distinct elements.
/* 
    i/p: a[] = [15,20,5,15]
         b[] = [15,15,15,20,10]

    o/p: 4
*/
public class _4_union_of_unsorted_array {

    /* 
        NAVIE approach:
            intitalize res = 0;    
            Create an auxiliary array dist = {};
            Traverese in array 1, and for every element check if it exsists in dist array.
            if not add it and res++, if it is already there continue; 
            Store the distinct elements in the new array {} with same process
            
        Time complexity : O(n*n + m*(n+m)))
    */

    static void navieApp(int[] arr1, int[] arr2){
        int[] dist = new int[100];
        int res = 0;
        for(int i = 0; i < arr1.length; i++ ){
            boolean flag = false;
            for(int j = 0; j <= res; j++ ){
                if( arr1[i] == dist[j] ){
                    flag = true;
                    break;
                } 
            }if( !flag ) dist[res++] = arr1[i]; 
        }
        for(int i = 0; i < arr2.length; i++ ){
            boolean flag = false;
            for(int j = 0; j <= res; j++ ){
                if( arr2[i] == dist[j] ){
                    flag = true;
                    break;
                }
            }if( !flag ) dist[res++] = arr2[i];
        }
        for(int i = 0; i < res; i++ ){
            System.out.print(dist[i] + " ");
        }
    }

/* 
    Efficient Approach: 
        Time complexity : theta(m + n)
        Aux Space : O(m + n)
    
        Initalize a new HashSet hs, 
        add all elements of a.
        add all elements of b.
        print hs.
        
*/
    static void efficApp(int[] a, int[] b){
        HashSet<Integer> hs = new HashSet<>();
        for(int i : a) hs.add(i);
        for(int i : b) hs.add(i);
        System.out.println(hs);
    }
    public static void main(String[] args) {
        int[] a = {15,20,5,15};
        int b[] = {15,15,15,20,10};
        // navieApp(a, b);
        efficApp(a, b);
    }
}
