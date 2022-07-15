// TWO POINTER:

// PROBLEM 1 : Given an unsorted array and a value x we need to find a pair whoes sum is equal to x.
/* 
    Navie: Run two for loops. O(n*n);
    for( int i =0; i < arr.length; i++ ){
        for( int j = i+1; j < arr.length; j++ ){
            if( arr[i] + arr[j] == target ){
                return new int[] {i, j};
            }
        }
    }

    Efficient: Use hashing
    HASHING:- It is a data structure which allows to insert delete and search in O(1) time.
    
    It take O(n) Time and O(n) extra space.
    - It is best for unsorted array.
    - If sorted array better approach is two pointer approach.

    Traverse to the array, and keep putting them in hash table. (insert)
    We check if x-arr[i] exits or not. (search)

    //CODE-

	static void printpairs(int arr[], int sum) 
	{ 
		HashSet<Integer> s = new HashSet<Integer>(); 
		for (int i = 0; i < arr.length; ++i) { 
			int temp = sum - arr[i]; 

			// checking for condition 
			if (s.contains(temp)) { 
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")"); 
			} 
			s.add(arr[i]); 
		} 
	} 

	// Main to test the above function 
	public static void main(String[] args) 
	{ 
		int A[] = { 1, 4, 45, 6, 10, 8 }; 
		int n = 16; 
		printpairs(A, n); 
	} 
} 
*/


// PROBLEM 2 : Given an sorted array we need to find pair of elements whoese sum is same as target.
/*

    intialize low and high.
    get there sum.
    if sum is same as target return indexes.
    else if sum is gerator i.e. we need to get low sum so high--
    else low++;

*/

public class _12_two_Pointer_Approaches {

    private static void sortedArrayFindDoubles( int[] arr,int x, int low, int high, int c ){
        while( low < high ){
            int sum = arr[low] + arr[high];
            if ( sum == x ){
                if( c != 0 )System.out.println( c + " " + arr[low] + " " + arr[high] );
                else System.out.println(arr[low] + " " + arr[high]);
                System.exit(0);
            }else if( sum > x ){
                high--;
            }else low++;
        }
    }

    public static void main(String[] args) {
        int num[] = { 2, 3, 4, 8, 9, 20, 40 };
        int arr[] = { 1,2,3,4,5 };
        int y = 32;
        int x = 28;
        sortedArrayFindDoubles(num, x, 0, num.length-1, 0);
        sortedArrayFindTriples(num, y, 0, num.length-1);
        sortedArrayStatisfy(arr, 0, arr.length-1);
    }
  

// PROBLEM 3: Given an sorted array and a target we need to 3 elements exits in array whose sum is equal to target.
/*  
    Navie solution is run is three loops.

    Efficient Solution: 
        We run a loop for every element and do sortedArrayFindTriples( arr, x-arr[i], i+1, size);

*/
    private static void sortedArrayFindTriples(int[] arr, int x, int low, int high){
        for(int i = 0; i < arr.length; i++ ){
            sortedArrayFindDoubles(arr, x-arr[i], low, high, arr[i]);
        }
    }

// PROBLEM 4: Given an array we need to statisfy a*a + b*b = c*c; for a,b,c
    private static void sortedArrayStatisfy(int[] arr, int low, int high){
        for(int i = arr.length-1; i >= 0; i-- ){
            int s = arr[i]*arr[i];
            high = i-1;
            while( low < high ){
                int sum = arr[low]*arr[low]  + arr[high]*arr[high];
                if( sum == s ){
                    System.out.println(s + " = " + arr[low]*arr[low] + " + " + arr[high]*arr[high]);
                    System.exit(0);
                }else if( sum < s )low++;
                else high--;
            }
        }
    }
}