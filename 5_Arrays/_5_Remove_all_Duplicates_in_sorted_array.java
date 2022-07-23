// Give an sorted array which contains some duplicates we need to remove all the duplicates.

public class _5_Remove_all_Duplicates_in_sorted_array {
    public static void main(String[] args) {
        int a[] = { 10, 20, 20, 30, 50, 50, 60 };
        int n = a.length;
        // We can modify in the same array and send all duplicates in the end or create a new array.
        // Initialise a index for new unique elements
        int k = 0;
        for( int i = 1 ; i < n; i++ ){
            // if unique we copy it to unique index position.
            if( a[k] != a[i]){
                a[k+1] = a[i];
                k++;
            }
        }

        System.out.println("RESULT: ");

        for( int i = 0; i <= k; i++ ){
            System.out.print(a[i] + " ");
        }

        /*
            int[] temp = new int[n];
            temp[0] = a[0];
            int k = 0;

            for( int i = 1; i < n; i++ ){
                if( a[i] != temp[k] ){
                    temp[k+1] = a[i];
                    k++;
                }
            }

            -> for loop to print the new array of k size.
        */
    }
}
