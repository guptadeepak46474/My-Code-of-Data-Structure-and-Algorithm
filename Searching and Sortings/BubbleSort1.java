// Bubble Sort

public class BubbleSort1 {
    public static void main(String args[])
    {
        BubbleSort1 ob = new BubbleSort1();
        int arr[] = {64, 34, 34, 25, 12, 22, 11, 90};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        ob.printArray(arr);
    }
    private void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for(int i = 0; i < n-1; i++) {
            swapped = false;
            for(int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
    }
    void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }   
}

// Output
// Sorted array
// 11 12 22 25 34 34 64 90