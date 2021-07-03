// Merge Sort

public class MergeSort {
    public static void main(String args[]){
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    private void sort(int[] arr, int l, int r) {
        int mid = l + (r - l) / 2;  // Find the middle point
        // Sort first and second halves
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        // Merge the sorted halves
        mergeSort(arr, l, mid, r);
    }

    private void mergeSort(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for(int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0;
        int k = l;  // Initial index of merged subarry array
        while(i < n1 && j < n2) {
            if(L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1) {     /* Copy remaining elements of L[] if any */
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {     /* Copy remaining elements of R[] if any */
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}