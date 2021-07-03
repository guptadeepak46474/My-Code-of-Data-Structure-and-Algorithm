// Stack | Set 2 (Infix to Postfix)
import java.util.*;

public class Stack11 {
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            if(Prec(c)>0){
                while(!stack.isEmpty() && Prec(stack.peek())>=Prec(c)){
                    result += stack.pop();
                }
                stack.push(c);
            }
            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                  
                stack.pop();
            }
            else {
                result += c;
            }
       
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    public static void main(String[] args) {
        String exp = "K+L-M*N+(O^P)*W/u/v*T+Q";
        System.out.println(infixToPostfix(exp));
    }
}