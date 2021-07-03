// Sliding Window Maximum (Maximum of all subarrays of size k)

public class Queue5 {
    public static void main(String args[]){
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        printKMax(arr, arr.length, k);
    }

    private static void printKMax(int[] arr, int n, int k) {
        int max;
        for(int i = 0; i <= n - k; i++) {
            max = arr[i];
            for(int j = 1; j < k; j++) {
                if(arr[i+j] > max)
                    max = arr[i+j];
            }
            System.out.print(max + " ");
        }
    }
}