// Counting Sort for positive value of array

import java.util.*;

public class CountingSorting {
    void sortCount(int[] arr, int n) {
        int k = Arrays.stream(arr).max().getAsInt();
        
        int[] count = new int[k+1];
        int[] output = new int[n];

        for(int i = 0; i <= k; i++)
            count[i] = 0;
        
        for(int i = 0; i < n; i++)
            count[arr[i]]++;
        
        for(int i = 1; i <= k; i++)
            count[i] = count[i] + count[i-1];
        
        for(int i = n-1; i >= 0; i--)
            output[--count[arr[i]]] = arr[i];
        
        for(int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    public static void main(String[] args) {
        CountingSorting cs = new CountingSorting();
        int[] arr = {3, 1, 5, 2, 7, 4, 9, 2, 6, 2, 0, 0, 1};
        int n = arr.length;
        cs.sortCount(arr, n);
        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// Output
// 0 0 1 1 2 2 2 3 4 5 6 7 9