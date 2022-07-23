package Stack;

import java.util.ArrayDeque;

// Given a string of parenthesis ({, }, (, ), [ and ]), we need to check if this string is balanced or not.
/*
    Ex: ([()])

    Here the latest opening brackets has to close first
    that is last in first out. LIFO
    Also number of closing brackets should be same as the number of opening brackets.

    Hence we can use Stack, to store the opening brackets and when we see a closig a bracket we match it with top of stack item using
    peek operation.

*/

public class balance_Paranthesis {

    // Solution 2ms
    static boolean matching(char i, ArrayDeque<Character> s) {
        return (i == ']' && s.pop() == '[' ||
                i == '}' && s.pop() == '{' ||
                i == ')' && s.pop() == '(');
    }

    static boolean balancePara(String str) {
        ArrayDeque<Character> s = new ArrayDeque<>();

        for (char i : str.toCharArray()) {
            if (i == '(' || i == '[' || i == '{')
                s.push(i);
            else if (!s.isEmpty() && matching(i, s))
                continue;
            else
                return false;
        }
        return s.isEmpty() ? true : false;
    }

    // 2ms O(n)
    static boolean balancePara2(String str) {
        ArrayDeque<Character> s = new ArrayDeque<>();
        for (char i : str.toCharArray()) {
            if (i == '(')
                s.push(')');
            else if (i == '[')
                s.push(']');
            else if (i == '{')
                s.push('}');
            else if (!s.isEmpty() && i == s.pop()) {
                continue;
            } else
                return false;
        }
        return s.isEmpty() ? true : false;
    }

    public static void main(String[] args) {
        // String str = "([()])";
        // String str = "{{}}";
        String str = "(])";

        System.out.println(balancePara2(str) ? "Yes" : "No");
        
        System.out.println(balancePara(str) ? "Yes" : "No");
    }
}
