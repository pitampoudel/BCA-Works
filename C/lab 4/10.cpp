//C program for palindrome number using recursion.
#include <stdio.h>

int reverseNumber(int num) {
    static int reversedNum = 0;

    if (num == 0) {
        return reversedNum;
    } else {
        reversedNum = reversedNum * 10 + num % 10;
        return reverseNumber(num / 10);
    }
}

int isPalindrome(int num) {
    int reversedNum = reverseNumber(num);
    return (num == reversedNum);
}

int main() {
    int number;

    printf("Enter a number: ");
    scanf("%d", &number);

    if (isPalindrome(number)) {
        printf("%d is a palindrome.\n", number);
    } else {
        printf("%d is not a palindrome.\n", number);
    }

    return 0;
}

