//WAP to print all the prime numbers between n1 and n2. Where n1 and n2 is entered by user.
#include <stdio.h>
int isPrime(int num) {
    if (num <= 1) {
        return 0;
    }
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) {
            return 0;
        }
    }
    return 1;
}

int main() {
    int n1, n2;

    printf("Enter the range (n1 and n2): ");
    scanf("%d %d", &n1, &n2);

    printf("Prime numbers between %d and %d are:\n", n1, n2);
    for (int i = n1; i <= n2; i++) {
        if (isPrime(i)) {
            printf("%d\n", i);
        }
    }
    return 0;
}

