package StacksandQueues;

import java.util.Scanner;
import java.util.Stack;

public class NonMatchingOpeningParenthesisBrackets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //Create a stack
        System.out.println(checkIfTheyHaveDuplicateBrackets(str));
    }

    private static boolean checkIfTheyHaveDuplicateBrackets(String str) {
        if (str.charAt(0) == ')') {
            return true;
        }

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            }
            if (ch == ')') {
                if (st.isEmpty()) {
                    return true;
                }
                Character peek = st.peek();
                if (peek == '(') {
                    st.pop();
                }
            }
        }
        if (st.isEmpty()) {
            return false;
        }
        return true;
    }
}
