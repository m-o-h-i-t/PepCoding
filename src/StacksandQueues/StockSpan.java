package StacksandQueues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
        System.out.println("Outputs are :");
        for(int val: a){
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] span = solve(a);
        display(span);
    }

/*
for the array [2 5 9 3 1 12 6 8 7]
span for 2 is 1
span for 5 is 2
span for 9 is 3
span for 3 is 1
span for 1 is 1
span for 12 is 6
span for 6 is 1
span for 8 is 2
span for 7 is 1
*/

    public static int[] solve(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] newArr = new int[arr.length];
        for (int i = 0;i <arr.length;i++){
            newArr[i] = arr[i];
        }


        st.push(0);
        arr[0] = 1;

        for (int i = 1;i< arr.length;i++){
            int cnt = 1;
            while(!st.isEmpty() && arr[i] > newArr[st.peek()]){
                cnt += arr[st.peek()];
                st.pop();
            }
            if (cnt == 1){
                arr[i] = 1;
            }else{
                arr[i] = cnt;
            }
            st.push(i);
        }

        return arr;
    }
}
