/*
    MULTIDIMENTIONAL ARRAYS:
    <data_type>[][] <varaible_name> = new int[row_size][column_size]
    Access as : <variable_name>[0][0] = 1st element.
    Memory allocation in Java is different from cpp.
    we can also create jagged array in java.
    As int[][] arr = new int[r][c];
    r = rows
    c = columns.

    here if we intialized only int[][] arr = new int[r][];
    EXAMPLE:
    for (int i = 0; i < arr.length; i++ ){
        arr[i] = new int[i+1];
        for( int j = 0; j < arr[i].length; i++ ){
            arr[i][j] = i;
        }
    }

    if r = 4;
    o/p :           0
                    1 1 
                    2 2 2 
                    3 3 3 3


*/
import java.util.Scanner;

public class _0_multidimensional_array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Get dimensions
        int r = sc.nextInt();
        int c = sc.nextInt();

        sc.close();
        // Initilaize 2d arry
        int[][] arr = new int[r][c];
        for( int i =0; i< arr.length; i++ ){
            for( int j = 0; j < arr[i].length; j++ ){
                arr[i][j] = sc.nextInt();
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }

        // JAGGED ARRAY:
        int n = 3;
        int brr[][] = new int[n][];
        for (int i = 0; i < brr.length; i++ ){
            brr[i] = new int[i+1];
            for( int j = 0; j < brr[i].length; j++ ){
                brr[i][j] = i;
                System.out.print(brr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}