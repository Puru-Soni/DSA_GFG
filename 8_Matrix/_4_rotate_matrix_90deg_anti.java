// Given a matrix we need to rotate the matrix in 90 degree in anti clockwise direction:

/* 
    [1 2 3]
    [4 5 6]

    after rotation: 
    [ 3 6 ]
    [ 2 5 ]
    [ 1 4 ]

*/

public class _4_rotate_matrix_90deg_anti {

    static int n = 3;
    // NAVIE APPROACH
    /* 
        create a new temp array and store each row in temp as inverted column.
        1 2 3 = 3
                2
                1
    */
    static void navieApproach(int[][] arr, int r, int c){
        int brr[][] = new int[r][c];

        for( int i = 0; i < c; i++ ){
            for( int j = 0; j < r; j++ ){
                brr[r-j-1][i] = arr[i][j];
            }    
        }

        for( int i = 0; i < r; i++ ){
            for( int j : brr[i] ){
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }

    // /////////////////////////////////////////////////

	static void rotate90(int mat[][])
	{

        // Transpose
		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++){
                int temp = mat[i][j];
			    mat[i][j] = mat[j][i];
			    mat[j][i] = temp;
            }
		
        // Swap high and low
		for(int i = 0; i < n; i++)
		{
		    int low = 0, high = n - 1;
		    while(low < high){
		        int temp = mat[low][i];
                mat[low][i] = mat[high][i];
                mat[high][i] = temp;
		        low++;
		        high--;
		    }
		}
	}
    public static void main(String[] args) {
        int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9}};
        // navieApproach(arr, 3, 2);
        
        // Efficient soltuion:
        /* 
            - If rows == column then its useful.
            - Transpose the matrix 
            - swap high = last(r-1) and low = 0 elements in each column.
        */
        rotate90(arr);

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j]+" ");
            }

            System.out.println();
        }
    }
}
