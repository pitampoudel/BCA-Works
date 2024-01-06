//Create a structure student having data members name, roll-number and percentage. Complete
//the program to display the name of the student having percentage greater than or equal to 60.
#include <stdio.h>

// Define the structure student
struct student {
    char name[50];
    int roll_number;
    float percentage;
};

int main() {
    int n;
    printf("Enter the number of students: ");
    scanf("%d", &n);

    struct student students[n];
    for (int i = 0; i < n; i++) {
        printf("Enter details for student %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", students[i].name);
        printf("Roll Number: ");
        scanf("%d", &students[i].roll_number);
        printf("Percentage: ");
        scanf("%f", &students[i].percentage);
    }
    printf("\nStudents with percentage >= 60:\n");
    for (int i = 0; i < n; i++) {
        if (students[i].percentage >= 60.0) {
            printf("Name: %s\n", students[i].name);
        }
    }

    return 0;
}

