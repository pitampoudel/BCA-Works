//WAP a program to read character from user and sort them in alphabetic order.
// (No matter the lower case or upper case)
#include <stdio.h>
#include <ctype.h>

int Compare(char a, char b) {
    return tolower(a) - tolower(b);
}

void BubbleSort(char arr[], int size) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = 0; j < size - i - 1; j++) {
            if (Compare(arr[j], arr[j + 1]) > 0) {
                char temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

int main() {
    int n;

    printf("Enter the number of characters: ");
    scanf("%d", &n);

    char characters[n];

    printf("Enter %d characters:\n", n);
    for (int i = 0; i < n; i++) {
        printf("Enter character %d: ", i + 1);
        scanf(" %c", &characters[i]);
    }
    BubbleSort(characters, n);

    printf("Characters in alphabetical order: ");
    for (int i = 0; i < n; i++) {
        printf("%c ", characters[i]);
    }
    printf("\n");

    return 0;
}

