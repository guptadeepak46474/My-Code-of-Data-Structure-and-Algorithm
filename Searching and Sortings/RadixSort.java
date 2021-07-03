// Radix Sort

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
    static void radixsort(int[] arr, int n) {
        int max = getMax(arr, n);
        for(int pos = 1; max/pos > 0; pos *= 10)
            countSort(arr, n, pos);
    }
    static void countSort(int[] arr, int n, int pos) {
        int[] output = new int[n];
        int[] count = new int[10];
        
        Arrays.fill(count, 0);

        for(int i = 0; i < n; i++)
            count[(arr[i]/pos)%10]++;
        for(int i = 1; i < 10; i++)
            count[i] += count[i-1];
        for(int i = n-1; i >= 0; i--)
            output[--count[(arr[i]/pos)%10]] = arr[i];
        for(int i = 0; i < n; i++)
            arr[i] = output[i];
    }
    static int getMax(int[] arr, int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}

// Output
// 2 24 45 66 75 90 170 802 