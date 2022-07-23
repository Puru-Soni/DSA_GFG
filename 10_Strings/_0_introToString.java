/*
    Strings are small set of characters. Sequence of Characters.
    128 Standard ASCII values.
    Java stores charactes in UFT-16 16-bit.
    Unicode Standard Format.

    Contiguous interger: 
    'a' : 97
    'A' : 65
*/

class introToString {
    public static void main(String[] args) {

        // Example: Print the frequency of a character in a string in sorted manner.

        String str = "geeksforgeeks";
        int[] cnt = new int[26];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                System.out.println((char) (i + 'a') + " of count " + cnt[i]);
            }
        }
    }
}

/*
Strings in JAVA:
    Character Array:
        char[] java = ['g', 'e', 'e', 'k', 's'];
        
        String Class: ( Immutable strings )
        String str = "Geeks";
        OR
        String str = new String("geeks");

        StringBuffer Class: ( multi-thread program with mutable strings, thread Safe)
        StringBuffer str = new StringBuffer("geeks")
      
        StringBuilder Class: ( 1-thread program with mutable strings, not thread Safe )
        StringBuilder str = new StringBuilder("geeks");

        String Class inlcudes many function / methods:
            object
            .length - return int
            .charAt(index) - return char
            .subString(startIndex, endIndex) - return string
            .contains(String) - return boolean , compares subString
            .equals(String) - return boolean , compares 'content'
            .compareTo(String) - return 0 (s1=s2) / +ve (s1>s2) / -ve (s1<s2) , compares String lexicographically
            .indexOf(String, startIndex) - return -ve(not exists) / index
            .concat(String)
            
        StringBuilder Class inlcudes many function / methods:
            obejct
            .append(String s)
            .insert(int offset, String s)
            .replace(int startIndex, int endIndex, String str)
            .delete(int startIndex, int endIndex)
            .reverse()
*/ 