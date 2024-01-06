//Write a program to define a structure named Person with Name, address, salary as data
//member. Enter value for five persons. Increases the salary by 15% each using function.
//Display the updated information.

#include <stdio.h>

struct Person {
    char Name[50];
    char address[100];
    float salary;
};

void increaseSalary(struct Person *person) {
    person->salary += person->salary * 0.15;
}

int main() {
    int n = 5;

    struct Person persons[n];

    for (int i = 0; i < n; i++) {
        printf("Enter details for person %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", persons[i].Name);
        printf("Address: ");
        scanf("%s", persons[i].address);
        printf("Salary: ");
        scanf("%f", &persons[i].salary);
    }

    for (int i = 0; i < n; i++) {
        increaseSalary(&persons[i]);
    }

    printf("\nUpdated Information:\n");
    for (int i = 0; i < n; i++) {
        printf("Person %d:\n", i + 1);
        printf("Name: %s\n", persons[i].Name);
        printf("Address: %s\n", persons[i].address);
        printf("Updated Salary: %.2f\n", persons[i].salary);
        printf("\n");
    }

    return 0;
}

