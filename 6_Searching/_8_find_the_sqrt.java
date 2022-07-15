import java.util.Scanner;

// Given an integer we need to find the floor of its square root.
// We use binary search to solve this problem:

/*

    WE CAN ALSO USE NEWTONS LAW:

    public int mySqrt(int x) {
        if (x == 0) return 0;
        long i = x;
        while(i > x / i)  
            i = (i + x / i) / 2;	    	
        return (int)i;
    }

    BUT POOR TIME COMPLEXITY.
*/



public class _8_find_the_sqrt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int low = 0;
        int high = x;
        int ans = 0;
        sc.close();

        if( x == 0 || x == 1 ){
            System.out.println(x);
            System.exit(0);
        }

    // A little trick is using i <= x / i for comparison, instead of i * i <= x, to avoid exceeding integer upper limit.

        while( low <= high ){
            int mid = low + (high-low)/2;
            if ( mid <= x/mid && (mid+1) > x/(mid+1) ){
                ans = mid;
                break;
            }else if ( mid > x/mid ){
                high = mid-1;
            }else{
                low = mid+1;
                ans = mid;
            } 
        }
        System.out.println(ans);
    }
}
