//WAP to find smallest number from the array using function.
#include <stdio.h>
int findSmallest(int arr[], int size) {
    int smallest = arr[0];

    for (int i = 1; i < size; i++) {
        if (arr[i] < smallest) {
            smallest = arr[i];
        }
    }

    return smallest;
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

    int smallest = findSmallest(numbers, n);

    printf("The smallest number in the array is: %d\n", smallest);

    return 0;
}

