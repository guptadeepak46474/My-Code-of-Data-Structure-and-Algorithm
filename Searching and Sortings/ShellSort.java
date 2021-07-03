// Shell Sort

public class ShellSort {
    public static void main(String args[])
    {
        int arr[] = {12, 34, 54, 2, 3};
        int n = arr.length;
        System.out.println("Array before sorting");
        printArray(arr);
 
        ShellSort ob = new ShellSort();
        ob.sort(arr, n);
 
        System.out.println("Array after sorting");
        printArray(arr);
    }
    void sort(int[] arr, int n) {

        for(int gap = n/2; gap >= 1; gap = gap/2)
            for(int j = gap; j < n; j++)
                for(int i = j-gap; i >= 0; i = i-gap)
                    if(arr[i+gap] > arr[i])
                        break;
                    else {
                        int temp = arr[i+gap];
                        arr[i+gap] = arr[i];
                        arr[i] = temp;
                    }
        
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

// Output
// Array before sorting
// 12 34 54 2 3
// Array after sorting
// 2 3 12 34 54