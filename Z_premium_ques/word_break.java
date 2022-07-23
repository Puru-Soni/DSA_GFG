import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class word_break {
    static List<String> wordBreak(int n, List<String> dict, String s) {
        int slow, fast;
        fast = 0;
        slow = 0;
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String res = "";
            String temp = "";
            while (fast < s.length()) {
                temp += s.charAt(fast);
                if (dict.indexOf(temp) != -1) {
                    if (slow == 0 && i != 0) {
                        fast    ++;
                        continue;
                    } else {
                        res += temp + " ";
                        temp = "";
                    }
                }
                fast++;
            }
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        int n = 5;
        List<String> res = wordBreak(n, dict, s);
        System.out.println(res);
    }
}
