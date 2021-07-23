package StacksandQueues;

import java.util.Scanner;
import java.util.Stack;

public class NeedlessBrackets {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(doesItHaveNeedlessBrackets(str));
    }

    private static boolean doesItHaveNeedlessBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0;i < str.length();i++){
            char ch = str.charAt(i);

            if (ch == ')'){
                if (st.peek() == '('){
                    //peek me hi mil gaya yaani iske andar koi content nahi to needless bracket
                    return true;
                }else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }

        }
        for (int i = 0;i <st.size();i++){
            if (st.peek()!='(' || st.peek() !=')'){
                st.pop();
            }
        }
        if (st.isEmpty()){
            return false;
        }
        return true;
    }
}
