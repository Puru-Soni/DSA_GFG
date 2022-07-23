// Given a matrix we need to print we in snake pattern

/* 
    [ 1 2 3 ]
    -------->
    [ 4 5 6 ]
    <--------
    [ 7 8 9 ]
    -------->

    o/p : 1 2 3 | 6 5 4 | 7 8 9.

    if row no is even we print left to right.
    else if row no is odd we print right to left.
*/

public class _1_snake_matrix {
    public static void main(String[] args) {
        int[][] snake = {   {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16} };
        for( int i = 0; i < snake.length; i++ ){
            if( i%2 == 0){
                for( int j = 0; j < snake[i].length; j++ ){
                    System.out.print(snake[i][j] + " ");
                }
            }else{
                for( int j = snake[i].length-1; j >= 0; j-- ){
                    System.out.print(snake[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
    } 
}