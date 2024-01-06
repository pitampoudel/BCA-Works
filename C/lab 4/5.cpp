//WAP to convert binary numbers to its equivalent decimal numbers
#include <stdio.h>
#include <math.h>

int binaryToDecimal(long long binary) {
    int decimal = 0, i = 0, remainder;

    while (binary != 0) {
        remainder = binary % 10;
        decimal += remainder * pow(2, i);
        ++i;
        binary /= 10;
    }

    return decimal;
}

int main() {
    long long binaryNumber;

    printf("Enter a binary number: ");
    scanf("%lld", &binaryNumber);

    int decimalNumber = binaryToDecimal(binaryNumber);
    printf("Decimal equivalent: %d\n", decimalNumber);

    return 0;
}

