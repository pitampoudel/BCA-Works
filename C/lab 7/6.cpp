//Write a C program to read name and marks of n number of 
//students from user and store them in a file
#include <stdio.h>

struct Student {
    char name[50];
    float marks;
};
int main() {
    FILE *file;
    struct Student students[100];
    int n;
    file = fopen("studentDetails.txt", "w");
    if (file == NULL) {
        printf("Error opening studentDetails.txt file for writing.\n");
        return 1;
    }
    printf("Enter the number of students: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("Enter details for student %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", students[i].name);
        printf("Marks: ");
        scanf("%f", &students[i].marks);

        fprintf(file, "Name: %s, Marks: %.2f\n", students[i].name, students[i].marks);
    }
    fclose(file);
    printf("Student details successfully written to studentDetails.txt.\n");
    return 0;
}

