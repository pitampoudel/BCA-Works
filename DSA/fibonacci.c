#include <stdio.h>

int fibonacci(int position)
{
    if (position <= 1)
    {
        return 1;
    }
    else
    {
        return fibonacci(position - 1) + fibonacci(position - 2);
    }
}

int main()
{
    int num = 6;
    printf("%d th fibonacci number is %d\n", num, fibonacci(num));
    printf("� Copyright Pitam Poudel. All Rights Reserved");
    return 0;
}
