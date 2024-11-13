public class MergeSort {

    // Main method to test the MergeSort implementation
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7}; // Sample array
        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1); // Call the mergeSort function

        System.out.println("\nSorted array:");
        printArray(arr);
    }

    // MergeSort function
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Recursively sort the first half
            mergeSort(arr, left, middle);

            // Recursively sort the second half
            mergeSort(arr, middle + 1, right);

            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }

    // Merge function to merge two sorted subarrays
    public static void merge(int[] arr, int left, int middle, int right) {
        // Find the sizes of the two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, middle + 1, rightArr, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArr[]
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArr[]
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    // Helper method to print the array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
