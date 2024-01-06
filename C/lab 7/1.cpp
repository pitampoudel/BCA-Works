// Write a program that reads data from a file “input.txt” 
//and writes to “output.txt” file. 
#include <stdio.h>

int main() {
    FILE *inputFile, *outputFile;
    char ch;

    inputFile = fopen("input.txt", "r");
    
    if (inputFile == NULL) {
        printf("Error opening input.txt file.\n");
        return 1;
    }

    outputFile = fopen("output.txt", "w");

    if (outputFile == NULL) {
        printf("Error opening output.txt file.\n");
        fclose(inputFile);
        return 1;
    }

    while ((ch = fgetc(inputFile)) != EOF) {
        fputc(ch, outputFile);
    }

    fclose(inputFile);
    fclose(outputFile);

    printf("Data successfully copied from input.txt to output.txt.\n");

    return 0;
}

