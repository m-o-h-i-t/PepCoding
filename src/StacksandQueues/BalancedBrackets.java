package StacksandQueues;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        //checkIfBalancedBrackets(string)
        System.out.println(checkIfBalancedBrackets(string));
    }

    private static boolean checkIfBalancedBrackets(String string) {
        Stack<Character> st = new Stack<>();
        for (int i = 0;i <string.length();i++){
            char ch = string.charAt(i);
            if (ch == ')' || ch == '}' || ch == ']'){
               boolean flag = doesPeekParenthesisMatch(ch,st);
               if (flag){
                   st.pop();
               }
               else{
                   return flag;
               }
            }
            if (ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }

        }
        if (st.isEmpty()){
            return true;
        }
        return false;

    }

    private static boolean doesPeekParenthesisMatch(char ch, Stack<Character> st) {
        if (!st.isEmpty()) {
            if (ch == ')' && st.peek() == '(') {
                return true;
            }
            if (ch == '}' && st.peek() == '{') {
                return true;
            }
            if (ch == ']' && st.peek() == '[') {
                return true;
            }
        }
        return false;
    }
}
