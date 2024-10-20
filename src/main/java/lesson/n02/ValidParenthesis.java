package lesson.n02;

import java.util.Stack;

public class ValidParenthesis {
    public static final int MAX_LENGTH = 100;

    public static boolean isValid(String s) {
        if (s == null) {
            throw new RuntimeException("Invalid input");
        }

        if (s.isEmpty() || s.length() > MAX_LENGTH) {
            throw new RuntimeException("Invalid input");
        }

        Stack<Character> parentheses = new Stack<>();
        char previous;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '[', '{':
                    parentheses.push(s.charAt(i));
                    break;
                case ')':
                    if (parentheses.isEmpty()) {
                        return false;
                    }
                    previous = parentheses.pop();
                    if (previous != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (parentheses.isEmpty()) {
                        return false;
                    }
                    previous = parentheses.pop();
                    if (previous != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (parentheses.isEmpty()) {
                        return false;
                    }
                    previous = parentheses.pop();
                    if (previous != '{') {
                        return false;
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid input");
            }
        }

        return (parentheses.isEmpty());
    }

    public static void main(String[] args) {
        String s1 = "[{()}]";
        System.out.println(s1 + " - " + isValid(s1)); // true
        String s2 = "[{()}";
        System.out.println(s2 + " - " + isValid(s2)); // false
        String s3 = "";
        System.out.println(s3 + " - " + isValid(s3)); // Exception
    }
}
