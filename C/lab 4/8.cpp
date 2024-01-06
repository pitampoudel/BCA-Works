//Sum of Natural Numbers Using Recursion.
#include <stdio.h>
int sumOfNaturalNumbers(int n) {
    if (n == 0) {
        return 0;
    } else {
        return n + sumOfNaturalNumbers(n - 1);
    }
}

int main() {
    int num;
    printf("Enter a positive integer: ");
    scanf("%d", &num);

    if (num < 1) {
        printf("Please enter a positive integer.\n");
    } else {
        int sum = sumOfNaturalNumbers(num);
        printf("Sum of first %d natural numbers is: %d\n", num, sum);
    }

    return 0;
}

