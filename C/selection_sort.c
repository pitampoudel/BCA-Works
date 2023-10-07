#include <stdio.h>

int main()
{
    int numbers[10], temp;

    for (int i = 0; i < 10; i++)
    {
        printf("enter number for index %d\n", i);
        scanf("%d", &numbers[i]);
    }

    for (int i = 0; i < 10; i++)
    {
        int minimum = numbers[i];
        for (int j = i + 1; j < 10; j++)
        {
            if (numbers[j] < numbers[i])
            {
                minimum = numbers[j];
            }
        }

        numbers[i] = minimum;
    }

    for (int i = 0; i < 10; i++)
    {
        printf("value at index %d is %d\n", i, numbers[i]);
    }

    return 0;
}