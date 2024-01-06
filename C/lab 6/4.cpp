//WAP to read structure “college” having name, EstDate and location where EstDate is an another
//structure having day month and year as members. Display records of 5 colleges. (Nested struct)

#include <stdio.h>

// Define the structure EstDate
struct EstDate {
    int day;
    int month;
    int year;
};

// Define the structure college
struct college {
    char name[50];
    struct EstDate establishmentDate;
    char location[50];
};

// Function to read information for 5 colleges
void readCollegeInfo(struct college *colleges, int n) {
    for (int i = 0; i < n; i++) {
        printf("Enter details for college %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", colleges[i].name);
        printf("Establishment Date (dd mm yyyy): ");
        scanf("%d %d %d", &colleges[i].establishmentDate.day,
              &colleges[i].establishmentDate.month,
              &colleges[i].establishmentDate.year);
        printf("Location: ");
        scanf("%s", colleges[i].location);
    }
}

// Function to display information for 5 colleges
void displayCollegeInfo(struct college *colleges, int n) {
    printf("\nCollege Information:\n");
    for (int i = 0; i < n; i++) {
        printf("College %d:\n", i + 1);
        printf("Name: %s\n", colleges[i].name);
        printf("Establishment Date: %02d/%02d/%04d\n",
               colleges[i].establishmentDate.day,
               colleges[i].establishmentDate.month,
               colleges[i].establishmentDate.year);
        printf("Location: %s\n", colleges[i].location);
        printf("\n");
    }
}

int main() {
    int n = 5;
    struct college colleges[n];
    readCollegeInfo(colleges, n);
    displayCollegeInfo(colleges, n);
    return 0;
}

