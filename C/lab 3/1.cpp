// Write a proram to store string in array and display 5 times.
#include <stdio.h>

int main() {
    char myString[100];

    printf("Enter a string: ");
    fgets(myString, sizeof(myString), stdin);

    for (int i = 0; i < 5; ++i) {
        printf("String #%d: %s", i + 1, myString);
    }

    return 0;
}
