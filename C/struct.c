#include <stdio.h>
void main()
{
    struct Person
    {
        char name[50];
    };

    struct Person persons[5];

    for (int i = 0; i++; i <= 5)
    {
        printf("Enter name\n");
        scanf("%d", &persons[i].name);
    }

    for (int i = 0; i++; i <= 5)
    {
        printf("%s\n", persons[i].name);
    }
}