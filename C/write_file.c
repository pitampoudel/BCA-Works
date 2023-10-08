#include <stdio.h>
struct Student
{
    char name[50];
    int roll_no;
    char gender[];
};

void main()
{
    struct Student students[5];

    for (int i = 0; i < 2; i++)
    {
        printf("%dth student's information\n", i);
        printf("Enter name\n");
        scanf("%s", &students[i].name);
        printf("Enter roll no\n");
        scanf("%d", &students[i].roll_no);
        printf("Enter gender\n");
        scanf("%s", &students[i].gender);
    }

    FILE *fp;
    fp = fopen("students.txt", "a");
    for (int i = 0; i < 2; i++)
    {

        fputs("\nName:", fp);
        fputs(students[i].name, fp);
        fputs("\n", fp);
        fputs("Roll No:", fp);
        fprintf(fp, "%d\n", students[i].roll_no);
        fputs("Gender:", fp);
        fputs(students[i].gender, fp);
        fputs("\n", fp);
    }

    fclose(fp);
}