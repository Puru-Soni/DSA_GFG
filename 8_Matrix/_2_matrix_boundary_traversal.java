// Given a matrix we need to do boundary traversal and print all the elements.
/* 
    ---------->
    A [1 2 3] |
    | [4 5 6] |
    | [7 8 9] |
    | [0 0 0] V
    <----------
    all boundary elements.

    if ( 1 row or 1 column ) print matrix as it is.
    else do
    - we need to first print row1
    - print last from row 2 to end.
    - print last row from end-1 element
    - print first element form end-1 row th to 2nd row.
    ( dont repeat boundary elements. )
*/

public class _2_matrix_boundary_traversal{ 
    public static void main(String[] args) {
        int[][] arr = { {1,2},
                        {5,6},
                        {9,10},
                        {13,14} };
    
        int r = arr.length;
        int c = arr[0].length;
        if( r == 1 ){
            for( int i =0 ; i < r; i++ ){
                System.out.print(arr[0][i] + " ");
            }
        }else if( c == 1){
            for( int i = 0 ; i < r; i++ ){
                System.out.print(arr[i][0] + " ");
            }
        }else{

            for(int i = 0; i < c; i++ ){
                System.out.print(arr[0][i] + " ");
            }
            for(int i = 1; i < r; i++ ){
                System.out.print(arr[i][c-1] + " ");
            }
            for(int i = c-2; i >= 0; i-- ){
                System.out.print(arr[r-1][i] + " ");
            }
            for(int i = r-2; i > 0; i-- ){
                System.out.print(arr[i][0] + " ");
            }
        }
    }
}
