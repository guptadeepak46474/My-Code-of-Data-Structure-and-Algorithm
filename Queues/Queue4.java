// Find the first circular tour that visits all petrol pumps

public class Queue4 {
    static class petrolPump {
        int pertol, distance;
        petrolPump(int pertol, int distance) {
            this.pertol = pertol;
            this.distance = distance;
        }
    }
    static int petrolTour(petrolPump arr[], int n) {
        int start = 0, end = 1;
        int curr_petrol = arr[start].pertol - arr[start].distance;
        while(start != end || curr_petrol < 0 ) {
            while(curr_petrol < 0 && start != end) {
                curr_petrol -= arr[start].pertol - arr[start].distance;
                start = (start + 1) % n;

                if(start == 0)
                    return -1;
            }
            curr_petrol += arr[end].pertol - arr[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }
    public static void main(String[] args) {
        petrolPump[] arr = {new petrolPump(6, 4),
                new petrolPump(3, 6),
                new petrolPump(7, 3)};
        int start = petrolTour(arr, arr.length);
        System.out.println((start == -1) ? "No Solution" : "Start = " + start);
    }
}

// Output
// Start = 2