// Counting Sort for negative value of array
import java.util.Arrays;

public class CountingSorting1 {
    void sortCount(int[] arr, int n) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        
        int[] count = new int[range];
        int[] output = new int[n];
        
        for(int i = 0; i < n; i++)
            count[arr[i]-min]++;
        
        for(int i = 1; i < count.length; i++)
            count[i] += count[i-1];
        
        for(int i = n-1; i >= 0; i--)
            output[--count[arr[i]-min]] = arr[i];
        
        for(int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    public static void main(String[] args) {
        CountingSorting1 cs = new CountingSorting1();
        int[] arr = {-3, 1, 5, -2, 7, 4, -9, 2, 6, 2, 0, 0, -1};
        int n = arr.length;
        cs.sortCount(arr, n);
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// Output
// -9 -3 -2 -1 0 0 1 2 2 4 5 6 7