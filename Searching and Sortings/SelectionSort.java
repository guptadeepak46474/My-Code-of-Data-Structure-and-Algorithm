// Selection Sort

public class SelectionSort {
    public static void main(String args[])
    {
        SelectionSort ob = new SelectionSort();
        int arr[] = {25,64,25,12,22,11};
        ob.sort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n-1; i++) {
            int min_index = i;
            for(int j = i+1; j < n; j++) {
                if(arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}

// Output
// Sorted array
// 11 12 22 25 25 64