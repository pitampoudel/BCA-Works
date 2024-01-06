//Find largest element in array using pointer
#include <stdio.h>
int findLargest(int *arr, int size) {
    int largest = *arr;

    for (int i = 1; i < size; i++) {
        if (*(arr + i) > largest) {
            largest = *(arr + i);
        }
    }

    return largest;
}

int main() {
    int numbers[5];

    printf("Enter 5 integers for the array:\n");
    for (int i = 0; i < 5; i++) {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &numbers[i]);
    }
    int largest = findLargest(numbers, 5);

    printf("The largest element in the array is: %d\n", largest);

    return 0;
}

