import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        // valid only if no unmatched brackets remain
        return stack.isEmpty();
    }
}
