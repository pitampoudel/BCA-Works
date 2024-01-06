// WAP to read and print data stored in a file INFO.txt.
#include <stdio.h>

#include <stdio.h>

int main() {
    FILE *file;
    char ch;
    file = fopen("INFO.txt", "r");
    
    if (file == NULL) {
        printf("Error opening INFO.txt file.\n");
        return 1;
    }

    printf("Data stored in INFO.txt:\n");
    while ((ch = fgetc(file)) != EOF) {
        putchar(ch);
    }

    fclose(file);

    return 0;
}


