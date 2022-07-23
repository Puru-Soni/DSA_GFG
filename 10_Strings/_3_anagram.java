import java.util.Arrays;

// Given two strings, we need to check if these strings are Anagram of each other or not.

public class _3_anagram {
    public static void main(String[] args) {
        String a = "listen";
        String b = "siltne";
        // Both are same in char frequecy hence, order do not matter.

        System.out.println(checkAnagramEff(a, b));
    }
    
    // Navie Solution:
    // Sort both the strings and compare them.
    static boolean checkAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;

        char[] fora = a.toCharArray();
        Arrays.sort(fora);
        a = new String(fora);

        char[] forb = b.toCharArray();
        Arrays.sort(forb);
        b = new String(forb);

        return a.equals(b);
    }

    // Efficient soluion:
    // Count sort - increment char count form one string and decrement from another
    static boolean checkAnagramEff(String a, String b){
        if (a.length() != b.length())
            return false;
        
        // Assuming only lowercase alphabets
        int[] cnt = new int[26];
        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if(cnt[i] != 0 ) return false;
        }
        return true;
    }
}
