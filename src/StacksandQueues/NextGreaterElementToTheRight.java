package StacksandQueues;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int arr[] = new int[arrSize];
        //fill the array
        for (int i = 0; i <arrSize;i++){
            arr[i] = sc.nextInt();
        }

        //call getNextGreaterElementToTheRigth
        arr = getNextGreaterElementToTheRight(arr,arrSize);
        display(arr);

    }

    private static void display(int[] arr) {
        for (int i = 0 ;i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }

    private static int[] getNextGreaterElementToTheRight(int[] arr, int arrSize) {
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1 ; i >= 0 ; i--){
            if (i == arr.length -1){
                st.push(arr[i]);
                arr[i] = -1;
            }else{
                int element = arr[i];
                if (st.isEmpty()){
                    st.push(arr[i]);
                    arr[i] = -1;
                }else {
                    boolean flag  = true;
                    while (st.peek()< element) {
                        flag = true;
                        st.pop();
                        if (st.isEmpty()){
                            st.push(arr[i]);
                            arr[i] = -1;
                            flag = false;
                        }

                    }
                    if (flag) {
                        int val = arr[i];
                        arr[i] = st.peek();
                        st.push(val);
                    }
                }

            }
        }
        return arr;
    }
}
