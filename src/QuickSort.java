public class QuickSort {

    // Main method to test the QuickSort implementation
    public static void main(String[] args) {
        int[] arr = { 10, 7, 8, 9, 1, 5 }; // Sample array
        int n = arr.length;

        System.out.println("Original array:");
        printArray(arr);

        quickSort(arr, 0, n - 1); // Call the quickSort function

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // QuickSort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort the two halves
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function to place pivot element at the correct position
    public static int partition(int[] arr, int low, int high) {
        // Pivot is the last element
        int pivot = arr[high];
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }

        // Swap arr[i + 1] and arr[high] (pivot)
        swap(arr, i + 1, high);

        return i + 1; // Return the partition index
    }

    // Helper method to swap two elements in the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

