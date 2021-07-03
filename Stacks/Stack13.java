// Stack | Set 3 (Reverse a string using stack)
import java.util.*;

public class Stack13 {
    public static void main(String args[])
    {
        //create a new string
        StringBuffer s= new StringBuffer("DeepakKing");
         
        //call reverse method
        reverse(s);
         
        //print the reversed string
        System.out.println("Reversed string is " + s);
    }

    private static void reverse(StringBuffer s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stack.push(c);
        }
        for(int i = 0; i < s.length(); i++) {
            char ch = stack.pop();
            s.setCharAt(i, ch);
        }
    }
}