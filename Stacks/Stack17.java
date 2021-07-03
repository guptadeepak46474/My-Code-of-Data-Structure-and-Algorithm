// Sort a stack using recursion
import java.util.*;

public class Stack17 {
    static void sortedInsert(Stack<Integer> s, int x) {
        if(s.isEmpty() || x > s.peek()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        sortedInsert(s, x);
        s.push(temp);
    }
    static void sortStack(Stack<Integer> s) {
        if(!s.isEmpty()) {
            int x = s.pop();
            sortStack(s);

            sortedInsert(s, x);
        }
    }
    static void printStack(Stack<Integer> s) {
        ListIterator<Integer> lt = s.listIterator();
        while(lt.hasNext()) {
            lt.next();
        }
        while(lt.hasPrevious()) {
            System.out.print(lt.previous() + " ");
        }
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        System.out.println("Stack elements before sorting: ");
        printStack(s);
        sortStack(s);
        System.out.println("\nStack elements after sorting:");
        printStack(s);
    }
}

//Output
// Stack elements before sorting: 
// -3 14 18 -5 30 
// Stack elements after sorting:
// 30 18 14 -3 -5