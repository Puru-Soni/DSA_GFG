// Given an unsorted array we need to find leaders:
// Leaders are those which are greator than its all right side elements.

public class _9_Get_all_Leaders {
    public static void main(String[] args) {
        int a[] = { 10, 20, 1, 15, 10, 1 };
        int  n = a.length;

        int curr = a[n-1];
        System.out.print(curr + " ");
        
        for(int i = n-2; i >= 0; i-- ){
            if( a[i] > curr ){
                curr = a[i];
                System.out.print(curr + " ");
            }
        }
    }
}
