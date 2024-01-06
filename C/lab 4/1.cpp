// WAP to print all the strong numbers between n1 and n2. Where n1 and n2 is entered by user
#include <stdio.h>
int factorial(int num) {
    if (num == 0 || num == 1) {
        return 1;
    } else {
        return num * factorial(num - 1);
    }
}
int isStrongNumber(int num) {
    int originalNum = num;
    int sum = 0;

    while (num > 0) {
        int digit = num % 10;
        sum += factorial(digit);
        num /= 10;
    }

    return (originalNum == sum);
}
int main() {
    int n1, n2;

    printf("Enter the range (n1 and n2): ");
    scanf("%d %d", &n1, &n2);
    printf("Strong numbers between %d and %d are:\n", n1, n2);
    for (int i = n1; i <= n2; i++) {
        if (isStrongNumber(i)) {
            printf("%d\n", i);
        }
    }
    return 0;
}

