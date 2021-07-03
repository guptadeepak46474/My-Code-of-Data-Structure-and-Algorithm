// Comb Sort

public class CombSort {
    public static void main(String args[])
    {
        CombSort ob = new CombSort();
        int arr[] = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
        ob.sort(arr);
 
        System.out.println("sorted array");
        for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
    void sort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        while(gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;
            for(int i = 0; i < n-gap; i++) {
                if(arr[i] > arr[i+gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;

                    swapped = true;
                }
            }
        }
    }
    int getNextGap(int gap) {
        gap = (gap*10)/13;
        if(gap < 1)
            return 1;
        return gap;
    }
}

// Output
// sorted array
// -44 -6 0 1 3 4 8 23 28 56