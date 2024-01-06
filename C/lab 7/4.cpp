//WAP to write name, roll no and age of five students into a disk file name "STUDENT.DAT". WAP to
//continuously read name, age and salary of a worker and write it into a file until user confirms to end.
//Then read n from user and display the nth record in the file. Details of worker must be represented by a
//structure.

#include <stdio.h>
struct Student {
    char name[50];
    int roll_no;
    int age;
};
struct Worker {
    char name[50];
    int age;
    float salary;
};
int main() {
    FILE *studentFile, *workerFile;
    struct Student students[5];
    struct Worker worker;
    int n, i;

    studentFile = fopen("STUDENT.DAT", "wb");
    if (studentFile == NULL) {
        printf("Error opening STUDENT.DAT file for writing.\n");
        return 1;
    }
    for (i = 0; i < 5; i++) {
        printf("Enter details for student %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", students[i].name);
        printf("Roll No: ");
        scanf("%d", &students[i].roll_no);
        printf("Age: ");
        scanf("%d", &students[i].age);

        fwrite(&students[i], sizeof(struct Student), 1, studentFile);
    }
    fclose(studentFile);

    workerFile = fopen("workerDetails.txt", "a");
    if (workerFile == NULL) {
        printf("Error opening workerDetails.txt file for writing.\n");
        return 1;
    }
    while (1) {
        printf("\nEnter details for a worker:\n");
        printf("Name: ");
        scanf("%s", worker.name);
        printf("Age: ");
        scanf("%d", &worker.age);
        printf("Salary: ");
        scanf("%f", &worker.salary);

        fprintf(workerFile, "Name: %s, Age: %d, Salary: %.2f\n", worker.name, worker.age, worker.salary);

        printf("Do you want to enter details for another worker? (1 for Yes, 0 for No): ");
        scanf("%d", &i);

        if (i != 1) {
            break;
        }
    }
    fclose(workerFile);
    printf("Enter the value of n to display the nth record: ");
    scanf("%d", &n);
    workerFile = fopen("workerDetails.txt", "r");
    if (workerFile == NULL) {
        printf("Error opening workerDetails.txt file for reading.\n");
        return 1;
    }
    printf("\nDetails of the nth record:\n");
    for (i = 1; i < n; i++) {
        if (fscanf(workerFile, "%*[^\n]")) {
            fgetc(workerFile);
        }
    }
    if (fscanf(workerFile, "%[^\n]", worker.name)) {
        printf("%s\n", worker.name);
    } else {
        printf("Record not found.\n");
    }
    fclose(workerFile);
    return 0;
}
 
