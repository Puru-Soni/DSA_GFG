public class _6_Move_all_Zero_To_End {
    public static void main(String[] args) {
        int a[] = { 10, 0, 11, 0, 12, 0 ,14, 15, 16, 0, 0};
        int n = a.length;

        int k = 0;
        for( int i = 0; i < n; i++ ){
            if( a[i] != 0 ){
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
                k++;
            }
        }
        for( int i = 0 ; i < k; i++ ){
            System.out.print(a[i] + " ");
        }
    }
}
