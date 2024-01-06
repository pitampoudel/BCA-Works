//Write a program to find sum and average of 10 integer numbers stored in array.
#include <stdio.h>
int main() {
    int numbers[10];
    printf("Enter 10 integers:\n");
    for (int i = 0; i < 10; ++i) {
        printf("Enter number #%d: ", i + 1);
        scanf("%d", &numbers[i]);
    }
    int sum = 0;
    for (int i = 0; i < 10; ++i) {
        sum += numbers[i];
    }
    double average = (double)sum / 10.0;
    printf("Sum: %d\n", sum);
    printf("Average: %.2lf\n", average);
    return 0;
}

