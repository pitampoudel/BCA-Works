// WAP to take data member using pointer structure from user (roll_no, name, age)
// and display all the details.
#include <stdio.h>

struct Student {
    int roll_no;
    char name[50];
    int age;
};

void inputStudentDetails(struct Student *student) {
    printf("Enter Roll Number: ");
    scanf("%d", &student->roll_no);

    printf("Enter Name: ");
    scanf("%s", student->name);

    printf("Enter Age: ");
    scanf("%d", &student->age);
}

void displayStudentDetails(struct Student *student) {
    printf("\nStudent Details:\n");
    printf("Roll Number: %d\n", student->roll_no);
    printf("Name: %s\n", student->name);
    printf("Age: %d\n", student->age);
}

int main() {

    struct Student student;
    inputStudentDetails(&student);
    displayStudentDetails(&student);
    return 0;
}

