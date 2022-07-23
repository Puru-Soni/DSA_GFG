public class _1_palindrom {
    public static void main(String[] args) {
        String str = "ABCCBA";
        if (str.length() == 1 || usingTwoPointer(str))
            System.out.println("It is Palindrom");
        else
            System.out.println("Not a Palindrome");
    }
    
    // Navie Solution O(n), O(n)
    public static boolean checkPalindromNaive(String str) {
        String str1 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str1 += str.charAt(i);
        }
        if (str1.equals(str))
            return true;
        else
            return false;
    }
    
    // Using StringBuilder Reverse fucntion theta(n) ,theta(n)
    public static boolean usingStringBuilder(String str) {
        StringBuilder str1 = new StringBuilder(str);
        str1.reverse();
        return str.equals(str1.toString());
    }

    // Efficicent Solution O(n/2), O(n/2)
    public static boolean checkPalindromEff(String str) {
        String str1 = "";
        while (str.length() > str1.length()) {
            str1 += str.charAt(str.length() - 1);
            str = str.substring(0, str.length() - 1);
        }
        if (str1.equals(str) || str1.substring(0, str1.length() - 1).equals(str))
            return true;
        return false;
    }

    // Using two pointer O(n), O(1)
    public static boolean usingTwoPointer(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--))
                return false;
        } return true;
    }
}