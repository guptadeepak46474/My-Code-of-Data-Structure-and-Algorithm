// Next Greater Element
import java.util.*;
public class Stack15 {
    static int arr[] = { 11, 13, 21, 3 };
    public static void printNGE() {
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            if(!s.empty()) {
                while(!s.empty() && s.peek() <= arr[i]) {
                    s.pop();
                }
            }
            nge[i] = s.empty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " --> " + nge[i]);
        }
    }
    public static void main(String[] args){
        printNGE();
    }
}

// Output
// 11 --> 13
// 13 --> 21
// 21 --> -1
// 3 --> -1 