//WAP to allocate memory dynamically in structure of 5 person
//and display information of 5 person.
#include <stdio.h>
#include <stdlib.h>

struct Person {
    char name[50];
    int age;
    float height;
};

int main() {
    int n = 5;
    struct Person *persons = (struct Person *)malloc(n * sizeof(struct Person));

    if (persons == NULL) {
        printf("Memory allocation failed.\n");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        printf("Enter details for person %d:\n", i + 1);
        printf("Name: ");
        scanf("%s", persons[i].name);
        printf("Age: ");
        scanf("%d", &persons[i].age);
        printf("Height: ");
        scanf("%f", &persons[i].height);
    }

    printf("\nPerson Information:\n");
    for (int i = 0; i < n; i++) {
        printf("Person %d:\n", i + 1);
        printf("Name: %s\n", persons[i].name);
        printf("Age: %d\n", persons[i].age);
        printf("Height: %.2f\n", persons[i].height);
        printf("\n");
    }
    free(persons);
    return 0;
}

