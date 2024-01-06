//Write a program to find smallest number among three numbers using if…else ladder and if else.
#include <stdio.h>

int main() {
    int num1, num2, num3;

    // Input three numbers
    printf("Enter three numbers: ");
    scanf("%d %d %d", &num1, &num2, &num3);

    // Find the smallest number using if...else statements
    if (num1 <= num2 && num1 <= num3) {
        printf("The smallest number is: %d\n", num1);
    } else if (num2 <= num1 && num2 <= num3) {
        printf("The smallest number is: %d\n", num2);
    } else {
        printf("The smallest number is: %d\n", num3);
    }

    return 0;
}

