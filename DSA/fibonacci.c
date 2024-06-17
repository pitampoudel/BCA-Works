#include <stdio.h>

int fibonacci(int n)
{
    if (n <= 1)
    {
        return n;
    }
    else
    {
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

int main()
{
    int num = 6;
    printf("%d th fibonacci number is %d\n", num, fibonacci(num));
    printf("© Copyright Pitam Poudel. All Rights Reserved");
    return 0;
}
