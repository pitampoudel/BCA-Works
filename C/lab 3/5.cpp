//Write a program to read marks obtained by n students in a subject and count the number of students whose mark is in between 60 and 80

#include <stdio.h>

int main() {
    int n;
    printf("Enter the number of students: ");
    scanf("%d", &n);

    int marks[n];
    int count = 0; 

    printf("Enter the marks for each student:\n");
    for (int i = 0; i < n; i++) {
        printf("Enter marks for student %d: ", i + 1);
        scanf("%d", &marks[i]);

        if (marks[i] >= 60 && marks[i] <= 80) {
            count++;
        }
    }

    printf("Number of students with marks between 60 and 80: %d\n", count);

    return 0;
}

