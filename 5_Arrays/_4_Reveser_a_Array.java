// Given an array we need to make it reverse and print the reverse array.
/**
 * array4ReveserArray
 */
public class _4_Reveser_a_Array {

    public static void main(String[] args) {
        int a[] = { 1,2,3,4,5,6 };
        int n = a.length;

        // intialising 2 pointers low and high.
        int low = 0;
        int high = n-1;
        // until we reach the mid element we swap from left most and right most sides.
        while( low < high ){
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;

            low++;
            high--;
        }

        // OR

        /*
            for( int i = 0; i < n/2; i++ ){
                int temp = a[i];
                a[i] = a[n-1-i];
                a[n-1-i] = temp;
            }
        */
        
        System.out.println("Reverse Array: ");

        for( int i = 0; i < n ; i++ ){
            System.out.print(a[i] + " ");
        }

        System.exit(0);
    }
}