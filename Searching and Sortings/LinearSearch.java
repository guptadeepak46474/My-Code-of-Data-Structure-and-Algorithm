// Linear Search

public class LinearSearch {
    public static void main(String[] args){
        int arr[] = { 1, 2, 3, 4, 5 };
        int search_element = 5;
        search(arr,search_element);
    }

    public static void search(int[] arr, int search_element) {
        int left = 0, right = search_element - 1, position = -1;
        for(left = 0; left <= right;) {
            if(arr[left] == search_element) {
                position = left;
                System.out.println(
                    "Element found in Array at "+ position + " Position with " + (left + 1) + " Attempt");
                break;
            }
            if(arr[right] == search_element) {
                position = right;
                System.out.println(
                    "Element found in Array at "+ position + " Position with " + (left + 1) + " Attempt");
                break;
            }
            left++;
            right--;
        }
        if (position == -1)
            System.out.println("Not found in Array with " + left + " Attempt");
    }
}

// Output
// Element found in Array at 4 Position with 1 Attempt