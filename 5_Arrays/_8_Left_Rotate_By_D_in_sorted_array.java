// Give an array we need to left rotate the array by D spaces.

import java.util.Scanner;

public class _8_Left_Rotate_By_D_in_sorted_array {

    static void reversal(int[] a, int low, int high){
        while( low < high )
        {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int a[] = { 1,2,3,4,5,6 };
        int n = a.length;
        int D = s.nextInt();
        s.close();
        // Two methods:
        // 1. efficient solution -> Using temp array.

        int[] temp = new int[D];
        for( int i = 0; i < D; i++ ){
            temp[i] = a[i];
        }

        for( int i = D; i < n; i++ ){
            a[i-D] = a[i];
        }

        for( int i = n-D; i < n; i++ ){
            a[i] = temp[ i-(n-D) ];
        }

        for( int i =0; i < n; i++ ){
            System.out.print(a[i] + " ");
        }

        // 2. Reserval Method - reverse the first D elements THEN reverse the rest elements THEN reverse the whole array.

        reversal(a, 0, D-1);
        reversal(a, D, n-1);
        reversal(a, 0, n-1);

        for( int i = 0; i < n; i++ ){
            System.out.print(a[i] + " ");
        }

    }
}
