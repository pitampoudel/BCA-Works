//Write a C program to accept 5 numbers, store them in array 
//and find out the smallest number using pointer.
#include <stdio.h>
int findSmallest(int *arr, int size) {
    int smallest = *arr;

    for (int i = 1; i < size; i++) {
        if (*(arr + i) < smallest) {
            smallest = *(arr + i);
        }
    }

    return smallest;
}

int main() {
    int numbers[5];
    printf("Enter 5 integers for the array:\n");
    for (int i = 0; i < 5; i++) {
        printf("Enter element %d: ", i + 1);
        scanf("%d", &numbers[i]);
    }
    int smallest = findSmallest(numbers, 5);
    printf("The smallest element in the array is: %d\n", smallest);

    return 0;
}

