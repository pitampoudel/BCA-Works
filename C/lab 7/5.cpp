//WAP to store employee details in a text file. Read data from the text file, sort them in ascending order
//of salary and store the sorted record to a binary file. Display the details and rank of employee given by
//the user. Write a C program to read numbers from a file and write even, odd and prime numbers in
//separate files.

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
s
struct Employee {
    char name[50];
    float salary;
};

int compareSalary(const void *a, const void *b) {
    return ((struct Employee *)a)->salary - ((struct Employee *)b)->salary;
}

int isPrime(int num) {
    if (num < 2) {
        return 0;
    }
    for (int i = 2; i <= sqrt(num); i++) {
        if (num % i == 0) {
            return 0;
        }
    }
    return 1;
}

int main() {
    FILE *employeeFile, *sortedFile, *evenFile, *oddFile, *primeFile;
    struct Employee employees[100];
    int n, rank, i;

    employeeFile = fopen("employeeDetails.txt", "w");
    if (employeeFile == NULL) {
        printf("Error opening employeeDetails.txt file for writing.\n");
        return 1;
    }

    printf("Enter the number of employees: ");
    scanf("%d", &n);

    for (i = 0; i < n; i++) {
        printf("Enter details for employee %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", employees[i].name);
        printf("Salary: ");
        scanf("%f", &employees[i].salary);

        fprintf(employeeFile, "Name: %s, Salary: %.2f\n", employees[i].name, employees[i].salary);
    }

    fclose(employeeFile);

    qsort(employees, n, sizeof(struct Employee), compareSalary);

    sortedFile = fopen("sortedEmployeeDetails.dat", "wb");
    if (sortedFile == NULL) {
        printf("Error opening sortedEmployeeDetails.dat file for writing.\n");
        return 1;
    }

    fwrite(employees, sizeof(struct Employee), n, sortedFile);

    fclose(sortedFile);

    printf("\nEnter the rank of the employee to display details: ");
    scanf("%d", &rank);

    if (rank >= 1 && rank <= n) {
        printf("\nDetails of employee at rank %d:\n", rank);
        printf("Name: %s\n", employees[rank - 1].name);
        printf("Salary: %.2f\n", employees[rank - 1].salary);
    } else {
        printf("Invalid rank entered.\n");
    }

    FILE *numbersFile, *evenNumbersFile, *oddNumbersFile, *primeNumbersFile;
    int number;

    numbersFile = fopen("numbers.txt", "r");
    if (numbersFile == NULL) {
        printf("Error opening numbers.txt file for reading.\n");
        return 1;
    }

    evenNumbersFile = fopen("evenNumbers.txt", "w");
    oddNumbersFile = fopen("oddNumbers.txt", "w");
    primeNumbersFile = fopen("primeNumbers.txt", "w");

    if (evenNumbersFile == NULL || oddNumbersFile == NULL || primeNumbersFile == NULL) {
        printf("Error opening output files for writing.\n");
        return 1;
    }

    while (fscanf(numbersFile, "%d", &number) != EOF) {
        if (number % 2 == 0) {
            fprintf(evenNumbersFile, "%d\n", number);
        } else {
            fprintf(oddNumbersFile, "%d\n", number);
        }

        if (isPrime(number)) {
            fprintf(primeNumbersFile, "%d\n", number);
        }
    }
    fclose(numbersFile);
    fclose(evenNumbersFile);
    fclose(oddNumbersFile);
    fclose(primeNumbersFile);

    printf("\nEmployee details, sorted employee details, and categorized numbers are written to files.\n");

    return 0;
}

