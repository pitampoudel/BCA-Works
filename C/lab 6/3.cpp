//Create a structure named student that has name, roll and marks as members. Assume
//appropriate types and size of members. Use this structure to read and display records of 3
//students. Create 2 functions. One is to read information of students and other to display the
//information. (Function)

#include <stdio.h>
struct student {
    char name[50];
    int roll;
    float marks;
};

void readStudentInfo(struct student *students, int n) {
    for (int i = 0; i < n; i++) {
        printf("Enter details for student %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", students[i].name);
        printf("Roll: ");
        scanf("%d", &students[i].roll);
        printf("Marks: ");
        scanf("%f", &students[i].marks);
    }
}

void displayStudentInfo(struct student *students, int n) {
    printf("\nStudent Information:\n");
    for (int i = 0; i < n; i++) {
        printf("Student %d:\n", i + 1);
        printf("Name: %s\n", students[i].name);
        printf("Roll: %d\n", students[i].roll);
        printf("Marks: %.2f\n", students[i].marks);
        printf("\n");
    }
}

int main() {
    int n = 3;
    struct student students[n];
    readStudentInfo(students, n);
    displayStudentInfo(students, n);

    return 0;
}

