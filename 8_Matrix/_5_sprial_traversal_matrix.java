public class _5_sprial_traversal_matrix {
    public static void main(String[] args) {
        int[][] arr = { {6, 6, 2, 28, 2}, {12, 26, 3, 28, 7}, {22, 25, 3, 4, 23} };
        /* 
            Given a matrix we need to print it in sprial form:
            o/p : 1 2 3 4 5 | 10 15 20 | 19 18 17 16 | 11 6 | 7 8 9 | 14 | 11 12
        
            We need to initialize 4 pointers.
        
            (top)
            1 2 3 4 5 (right)
            6 7 8 9 10
            11 12 13 14 15
     (left) 16 17 18 19 20
                     (bottom)
        
            top= top row
            bottom= bottom row
            right= last column
            left= start column           
        
            print top row then top++;
            print last column then right--;
            print last row then bottom--;
            print first column then left++;
        
            repeat until ->  top < bottom && left < right
        */
        int top = 0;
        int right = arr[0].length-1;
        int bottom = arr.length-1;
        int left = 0;
        
        while( top <= bottom && left <= right ){
            for( int i = left; i <= right; i++ )
                System.out.print(arr[top][i] + " ");
            ++top;
            for(int i = top; i <= bottom; i++ )
                System.out.print(arr[i][right] + " ");
            --right;
            if( top <= bottom ){
                for(int i = right; i >= left; i-- )
                    System.out.print(arr[bottom][i] + " ");
                --bottom;
            }
            if( left <= right ){
                for( int i = bottom; i >= top; i-- )
                    System.out.print(arr[i][left] + " ");
                ++left;
            }
        }
    }
}