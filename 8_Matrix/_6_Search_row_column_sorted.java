public class _6_Search_row_column_sorted {
    public static void main(String[] args) {
        // int[][] arr = { {10, 20, 30, 40},
        //                 {15, 25, 35, 45},
        //                 {27, 29, 37, 48},
        //                 {32, 33, 39, 50}};

        int arr[][] =   {{19 ,22 ,25 ,25 ,33 ,39 ,45 ,49 ,53 ,55 ,60 ,63 ,65 ,66 ,73 ,76 ,78 ,81 ,81 ,85},
                        {7, 9 ,11 ,14 ,19 ,20 ,33, 34, 36, 41, 52, 66, 71, 72, 73, 81, 81, 87, 90, 99, 2},
                        {3, 4, 8, 8, 19, 20, 21, 26, 44 ,53 ,53 ,54 ,55 ,73 ,74 ,74 ,81 ,92 ,92},
                        {6 ,14 ,22 ,28 ,31 ,32 ,33 ,34 ,35 ,36 ,40 ,41 ,41 ,44 ,57, 64, 65, 67, 86, 91}};
        int target = 73;
        
        // Given a arr that is row-wise sorted and column-wise sorted.
        // Also given a value x that we need to find in the arr.
        /* 
            NAVIE SOLUTION:
            time complexity : O(r*c)
            r = row
            c = column
            
            we traverse the arr using two for loop,
            if element is found we print its index
            else print not found.

            for( int i = 0; i < r; i++ ){
                for( int j = 0; j < c; j++ ){
                    if( arr[i][j] == target ){
                        return (i,j);
                    }
                }
            }
            return "NOT FOUND";
        */
        
        // for( int i = 0; i < arr.length; i++ ){
        //     for( int j = 0; j < arr[i].length; j++ ){
        //         if( arr[i][j] == target ){
        //             System.out.println("Navie Sol: " + i + "," + j);
        //         }
        //     }
        // }

        /* 
            EFFICIENT SOLUTION:
            time complexity : O(r+c)
            r = row
            c = column

            - Begin the traverse from top right corner.
            - if x is same return true
            - else if x is smaller move left
            - else move down

            BUT WHY FROM TOP RIGHT CORNER? WHY NOT FROM OTHE CORNER?
            {
                We can use TOP RIGHT or BOTTOM LEFT corner for the efficient solution.

                We can use BOTTOM LEFT:
                    if element is same we return 
                    else if element is small we move up bottom--;
                    else left++;

                Else if we assume TOP LEFT{
                    if element is smaller than first hence it does not exits but 
                    if element is larger we dont know where to move top++ or left++;
                }Same with BOTTOM RIGHT{
                    if elment is grator than last element hecec it in not present but
                    if element is smaller than is cannot decide to bottom-- or right--;
                }
            }

        */

        System.out.println( "Eff. Sol: " + chkEl(arr, target));
    }
    static String chkEl(int[][]arr , int target){
        int top = 0;
        int right = arr[0].length-1;
        
        // SLIGHTLY OPTIMIZED:
        if( arr[0][0] > target || arr[arr.length-1][right] < target ) return "NOT FOUND";
        
        while( top < arr.length && right >= 0 ){
            if( arr[top][right] == target ) return (String)(top + "," + right);
            else if( target < arr[top][right] ) right--;
            else top++;
        }return "Not Found";
    }
}
