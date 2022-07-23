public class Strings_408_valid_word_abrivation {
    public static void main(String[] args) {
        String s = "internationalization";
        String abr = "i12iz4n";
        System.out.println(checkValidAbbrivation(s, abr));
    }
    
    static boolean checkValidAbbrivation(String s, String abr) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < abr.length()) {
            String inc = "";
            while( '0' <= abr.charAt(j) && abr.charAt(j) >= '9' ) {
                inc += Character.toString(abr.charAt(j));
                j++;
            }
            if (inc != "" && inc != "0") {
                i += Integer.valueOf(inc);
            }
            while (s.charAt(i) == abr.charAt(j)) {
                i++;
                j++;
            }
            if (i > s.length())
                return false; 
        }                                                      
        return true;
    }
}
