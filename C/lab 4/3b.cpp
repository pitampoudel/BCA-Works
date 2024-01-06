//WAP to print all the perfect numbers between n1 and n2. Where n1 and n2 is entered by user.
//(Using for Loop, using while Loop, Using Recursion)

#include <stdio.h>

int sumOfDivisors(int num, int i) {
    if (i == 1) {
        return 1;
    }
    if (num % i == 0) {
        return i + sumOfDivisors(num, i - 1);
    } else {
        return sumOfDivisors(num, i - 1);
    }
}

int isPerfect(int num) {
    return (num == sumOfDivisors(num, num / 2));
}

void displayPerfectNumbers(int n1, int n2) {
    if (n1 <= n2) {
        if (isPerfect(n1)) {
            printf("%d\n", n1);
        }
        displayPerfectNumbers(n1 + 1, n2);
    }
}

int main() {
    int n1, n2;

    printf("Enter the range (n1 and n2): ");
    scanf("%d %d", &n1, &n2);

    printf("Perfect numbers between %d and %d are:\n", n1, n2);
    displayPerfectNumbers(n1, n2);

    return 0;
}

