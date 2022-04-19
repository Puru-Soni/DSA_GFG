import java.util.HashMap;
import java.util.Map;

// Given an array we need to print frequences of all the elements.
/* 
    EX:  [10,12,10,15,10,20,12,12];
    o/p: 10 3
         12 3
         15 1
         20 1
*/
public class _2_Freq_of_array_elements {
    public static void main(String[] args) {

    // NAVIE APPROACH:
    /* 
        Time - O(n*n)
        Aux - O(1)

        We run a for loop for every element checking 1st if we have already taken that element and checked for its freq
        by checking if in left side it appears again. As we move left to right.

        for(int i=0; i<n; i++ ){ 
            boolean chk = false;
            for(int j =0; j < i; j++ ){
                if( arr[i] == arr[j] ) 
                    chk = true;
                    break;    
            }
            if( chk == true )
                continue;

        If we encouner the first occurence of an element the above condition is false and we count the freq of that element.

            int freq = 0;
            for(int j=i+1; j < n; j++ ){
                if( arr[i] == arr[j] ) freq++;
            }
            print("element : " + arr[i] + " has freq of " + freq);
        }        
    */
        
    // Efficient Appraoch:
    /* 

    */
        int[] arr = {10,20,20,30,10};
        HashMap<Integer, Integer> hs = new HashMap<>();
        // Here the function getorDefault take 2 parameter 'key' and its corresponding default 'value'.
        // If the key is new or it do not exists already its default value is set.
        // else it returns the already associated value form the hashMap.
        for( int x : arr){
            hs.put(x, hs.getOrDefault(x, 0) + 1 );
        }

        /* 
            entrySet() method in Java is used to create a set out of the same elements contained in the hash map. 
            It basically returns a set view of the hash map or we can create a new set and store the map elements into them.
        */
        for( Map.Entry<Integer, Integer> e : hs.entrySet() ){
            System.out.println(e.getKey() + " " + e.getValue());    
        }
        // If we want to print the elements in the ordered manner as they were inserted we can use LINKED HASHMAP.
        
    }
}
