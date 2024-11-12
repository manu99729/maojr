import java.util.Arrays;

public class InsertElement {

    public static int[] insertElement(int[] arr, int element, int position) {
        // If position is invalid, return the original array
        if (position < 0 || position > arr.length) {
            System.out.println("Invalid position");
            return arr;
        }

        // Create a new array with an extra space to accommodate the new element
        int[] newArr = new int[arr.length + 1];

        // Copy elements before the specified position
        for (int i = 0; i < position; i++) {
            newArr[i] = arr[i];
        }

        // Insert the new element at the specified position
        newArr[position] = element;

        // Copy the remaining elements after the specified position
        for (int i = position; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};

        System.out.println("Original array: " + Arrays.toString(arr));

        // Insert element 4 at position 3
        int[] newArr = insertElement(arr, 4, 3);

         System.out.println("Array after insertion: " + Arrays.toString(newArr));
    }
}
