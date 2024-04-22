#include <stdio.h>

int binarySearch(int arr[], int start_index, int end_index, int query) {
    if (end_index >= start_index) {
        int mid_index = start_index + (end_index - start_index) / 2;

        // If the element is present at the middle
        if (arr[mid_index] == query)
            return mid_index;

        // If element is smaller than mid, then it can only be present in left subarray
        if (arr[mid_index] > query)
            return binarySearch(arr, start_index, mid_index - 1, query);

        // Else the element can only be present in right subarray
        return binarySearch(arr, mid_index + 1, end_index, query);
    }

    // We reach here when element is not present in array
    return -1;
}

int main(void) {
    int arr[] = {2, 3, 4, 10, 40};
    int query = 10;
    int result = binarySearch(arr, 0, 4, query);
    (result == -1) ? printf("Element is not present in array\n")
                   : printf("Element is present at index %d\n", result);
    return 0;
}

