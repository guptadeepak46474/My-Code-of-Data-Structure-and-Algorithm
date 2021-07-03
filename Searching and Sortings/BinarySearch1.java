// Binary Search
public class BinarySearch1 {
    public static void main(String args[]){
        BinarySearch1 ob = new BinarySearch1();
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        int result = ob.binarySearch(arr, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }

    private int binarySearch(int[] arr,int x) {
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int m = l + (r-l)/2;
            if(arr[m] == x)
                return m;
            if(arr[m] < x)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }
}

// Output:
// Element found at index 3