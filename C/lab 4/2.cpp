//WAP to display all the prime factors of given number.
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
void displayPrimeFactors(int num) {
    printf("Prime factors of %d are: ", num);

    for (int i = 2; i <= num; i++) {
        if (num % i == 0 && isPrime(i)) {
            printf("%d ", i);
        }
    }

    printf("\n");
}

int main() {
    int number;
    printf("Enter a number: ");
    scanf("%d", &number);

    displayPrimeFactors(number);
    return 0;
}

