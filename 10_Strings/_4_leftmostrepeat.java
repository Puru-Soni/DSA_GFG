// Given a string, the task is to find the first character (whose leftmost appearance is first) that repeats.

public class _4_leftmostrepeat {
    public static void main(String[] args) {
        // String str = "geekforgeeks";
        String str = "abbcc";

        navieApproach(str);
        usingmethods(str);
    }

    // More naive approach can be n*n
    // O(n*n) time
    static void navieApproach(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    System.out.println(i);
                    return;
                }
            }
        }
        System.out.println(-1);
    }

    // using in built String functions
    static void usingmethods(String str) {
        int i = 0;
        String x = Character.toString(str.charAt(i));
        while (str.indexOf(x) == str.lastIndexOf(x)) {
            i++;
            x = Character.toString(str.charAt(i));
        }
        if (str.indexOf(x) != str.lastIndexOf(x))
            System.out.println(i);
        else
            System.out.println(-1);
    }

    // using array to store frequency of character
    // O(n)
    static final int CHAR = 256;

    static void usingArray(String str) {
        int[] count = new int[CHAR];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] > 1) {
                System.out.println(i);
                return;
            }
        }
    }
    
    // Efficient Solution - 1
    static void effSolution1(String str) {
        
    }
}
