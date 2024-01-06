//WAP to print all the perfect numbers between n1 and n2. Where n1 and n2 is entered by user.
//(Using for Loop, using while Loop, Using Recursion)

#include <stdio.h>
int isPerfect(int num) {
    int sum = 0;
    for (int i = 1; i <= num / 2; i++) {
        if (num % i == 0) {
            sum += i;
        }
    }
    return (num == sum);
}

int main() {
    int n1, n2;

    printf("Enter the range (n1 and n2): ");
    scanf("%d %d", &n1, &n2);

    printf("Perfect numbers between %d and %d are:\n", n1, n2);
    for (int i = n1; i <= n2; i++) {
        if (isPerfect(i)) {
            printf("%d\n", i);
        }
    }

    return 0;
}

