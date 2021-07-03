// Reverse a stack using recursion

import java.util.*;

public class Stack16 {
    static Stack<Character> st = new Stack<>();
    static void insert_at_bottom(char x) {
        if(st.isEmpty())
            st.push(x);
        else {
            // char a = st.peek();
            // st.pop();
            // insert_at_bottom(x);
            // or
            char a = st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }
    static void reverse() {
        if(st.size() > 0) {
            // char x = st.peek();
            // st.pop();
            // reverse();
            // or
            char x = st.pop();
            reverse();
            insert_at_bottom(x);
        }
    }
    public static void main(String[] args) 
    {
        st.push('1');
        st.push('2');
        st.push('3');
        st.push('4');
          
        System.out.println("Original Stack");
        System.out.println(st);
        reverse();
        System.out.println("Reversed Stack");
        System.out.println(st);
    }
}

// Output
// Original Stack
// [1, 2, 3, 4]  
// Reversed Stack
// [4, 3, 2, 1]