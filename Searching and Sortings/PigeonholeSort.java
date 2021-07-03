// Pigeonhole Sort

import java.util.Arrays;

public class PigeonholeSort {
    public static void main(String[] args)
    {
        PigeonholeSort sort = new PigeonholeSort();
        int[] arr = {8, 3, 2, 7, 4, 6, 8};
 
        System.out.print("Sorted order is : ");
 
        sort.pigeonhole_sort(arr,arr.length);
         
        for(int i=0 ; i<arr.length ; i++)
            System.out.print(arr[i] + " ");
    }

    public void pigeonhole_sort(int[] arr, int n) {
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < n; i++) {
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }
        
        int range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(int i = 0; i < n; i++)
            phole[arr[i] - min]++;
        
        int index = 0;

        for(int i = 0; i < range; i++)
            while(phole[i]-- > 0)
                arr[index++] = i+min;
    }
}

// Output
// Sorted order is : 2 3 4 6 7 8 8