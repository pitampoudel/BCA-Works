//WAP to find palindrome.
#include <stdio.h>
#include <string.h>

int main() {
    char word[100];

    printf("Enter a word: ");
    scanf("%s", word);

    int length = strlen(word);
    int isPalindrome = 1;

    for (int i = 0; i < length / 2; i++) {
        if (word[i] != word[length - 1 - i]) {
            isPalindrome = 0;
            break;
        }
    }

    if (isPalindrome) {
        printf("%s is a palindrome.\n", word);
    } else {
        printf("%s is not a palindrome.\n", word);
    }

    return 0;
}

