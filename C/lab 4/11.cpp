//Find the Smallest Element in an Array using recursion.
#include <stdio.h>

int findSmallestRecursive(int arr[], int size) {
    if (size == 1) {
        return arr[0];
    }

    int smallestInRest = findSmallestRecursive(arr, size - 1);

    return (arr[size - 1] < smallestInRest) ? arr[size - 1] : smallestInRest;
}

int main() {
    int n;

    printf("Enter the size of the array: ");
    scanf("%d", &n);

    int numbers[n];

    printf("Enter %d integers for the array:\n", n);
    for (int i = 0; i < n; i++) {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &numbers[i]);
    }

    int smallest = findSmallestRecursive(numbers, n);

    printf("The smallest element in the array is: %d\n", smallest);

    return 0;
}

