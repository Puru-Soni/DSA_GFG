// Given two strings we need to find if the a string is sub-Sequence of another String or not
// Substring : contiguous order, SubSequence: In same Sequence / order but not contiguous.

/*
    Sub-Sequence:
        "ABC" : {"" , "A", "AB", "AC", "ABC", "B", "BC", "C" }
*/

public class _2_checkSubSequence {
    public static void main(String[] args) {
        String a = "ABCDE";
        String b = "AED";

        // if (checkSubSequence(a, b)) 
        if(isSubSeq(a, b, a.length(), b.length()) ){
            System.out.println("It is a subSequence String");
        } else {
            System.out.println("Not a subSequence String");
        }
    }

    // Using Built in methods
    public static boolean checkSubSequence(String a, String b) {
        int j = 0;
        for(int i = 0; i < b.length(); i++ ){
            int x = a.indexOf(Character.toString(b.charAt(i)), j);
            if (x <= -1)
                return false;
            j = x + 1;
        }
        return true;
    }
    
    // Iterative Solution:
    public static boolean isSubSeq(String s1, String s2, int n ,int m) {
        int j = 0;
        for (int i = 0; i < n && j < m; i++) {
            if (s1.charAt(i) == s2.charAt(j))
                j++;
        }
        return j == m;
    }
    
    // Recursive solution:
    static boolean isSubSeqR(String s1, String s2, int n, int m) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;

        if (s1.charAt(n - 1) == s2.charAt(m - 1))
            return isSubSeqR(s1, s2, n - 1, m - 1);
        else
            return isSubSeqR(s1, s2, n - 1, m);
    }
}