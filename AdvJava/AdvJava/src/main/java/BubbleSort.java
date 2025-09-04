public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        int[][] tests = {{5, 2, 8, 1, 9}, {1, 2, 3, 4, 5}, {5, 4, 3, 2, 1}};
        for (int[] arr : tests) {
            System.out.print("Original: ");
            for (int x : arr) System.out.print(x + " ");
            bubbleSort(arr);
            System.out.print("-> Sorted: ");
            for (int x : arr) System.out.print(x + " ");
            System.out.println();
        }
    }
}
