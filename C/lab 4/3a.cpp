//WAP to print all the perfect numbers between n1 and n2. Where n1 and n2 is entered by user.
//(Using for Loop, using while Loop, Using Recursion)

#include <stdio.h>
int isPerfect(int num) {
    int sum = 0;
    int i = 1;
    while (i <= num / 2) {
        if (num % i == 0) {
            sum += i;
        }
        i++;
    }
    return (num == sum);
}
int main() {
    int n1, n2;

    printf("Enter the range (n1 and n2): ");
    scanf("%d %d", &n1, &n2);
    printf("Perfect numbers between %d and %d are:\n", n1, n2);
    int num = n1;
    while (num <= n2) {
        if (isPerfect(num)) {
            printf("%d\n", num);
        }
        num++;
    }
    return 0;
}

