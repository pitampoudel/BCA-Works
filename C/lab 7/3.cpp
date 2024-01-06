//WAP C Program – Writing string to a file int fputs ( const char * s, FILE * fpw ); char*s –Array_of_char.
//FILE *fpw – Pointer (of FILE type) to the file, which is going to be written. 
#include <stdio.h>

int main() {
    FILE *file;
    char str[100];

    file = fopen("output.txt", "w");

    if (file == NULL) {
        printf("Error opening output.txt file.\n");
        return 1;
    }
    printf("Enter a string to write to the file: ");
    fgets(str, sizeof(str), stdin);


    fputs(str, file);
    fclose(file);

    printf("String successfully

