// Give sorted binary array we need to count the number of 1's in the array.


// We find the first occurence of the 1's using binary search.
public class _7_cnt_Ones {

    public static int firstOcc(int[] a, int x, int low, int high){
        while( low <= high ){

            int mid = (low+high)/2;

            if( a[mid] == 0 ){
                low = mid+1;
            }else{
                if( mid == 0 || a[mid] != a[mid-1] ){
                    return mid;
                }else high = mid-1;
            }
        }
        return -1;
    } 
    public static void main(String[] args) {
        int[] a = { 0, 0, 1,1,1,1,1,1 };
        int i = firstOcc(a, 1, 0, a.length-1);
        if( i != -1 ) System.out.println( a.length-1 - i + 1 );
        else System.out.println(0);
    }
}
