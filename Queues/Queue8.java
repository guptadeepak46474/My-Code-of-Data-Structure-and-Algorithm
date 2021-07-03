// An Interesting Method to Generate Binary Numbers from 1 to n
import java.util.*;
public class Queue8 {
    public static void main(String[] args) {
        int n = 10;
        generatePrintBinary(n);
    }

    static void generatePrintBinary(int n) {
        Queue<String> q = new LinkedList<String>();
        q.add("1");
        while(n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.println(s1);
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }   
}

// Output
// 1
// 10 
// 11 
// 100
// 101
// 110
// 111
// 1000
// 1001
// 1010