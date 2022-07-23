// Given a 2d matrix we need to print the transpose of the matrix.
/* 
    example: 
    [ 1 2 3 ]
    [ 4 5 6 ]
    [ 7 8 9 ]

    here we swap( 2,4 ) , swap( 3,7 ), swap( 6,8 )
    that is for every ith row we swap from i+1 index.
    i = 0;
    i = 1 and i = 2 are swap with j = 1 and j = 2.
    arr[i][j] =swap= arr[j][i];
    
*/

public class _3_transpose_of_matrix {
    public static void main(String[] args) {
        int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
        // ORIGINAL MATRIX
        for(int i = 0; i < arr.length; i++ ){
            for(int j : arr[i] ){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
        // OPERATION TO TRANSPOSE
        for( int i = 0; i < arr.length; i++ ){
            for(int j = i+1; j < arr[i].length; j++ ){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        // TRANSPOSED MATRIX
        for(int i = 0; i < arr.length; i++ ){
            for(int j : arr[i] ){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
