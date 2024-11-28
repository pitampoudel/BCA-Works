#include <stdio.h>
#include <conio.h>
#include <math.h>
#define f(x) (a3 * x * x * x + a2 * x * x + a1 * x + a0)
#define fd(x) (3 * a3 * x * x + 2 * a2 * x + a1)
float a0, a1, a2, a3;
int main()
{
    float x0, x1, x2, fx0, fx1, E, ER;
    printf("Enter coefficient a3,a2,a1,a0\n");
    scanf("%f%f%f%f", &a3, &a2, &a1, &a0);
    printf("Enter initial two guesses and E\n");
    scanf("%f%f%f", &x0, &x1, &E);
    while (1)
    {
        fx0 = f(x0);
        fx1 = f(x1);
        x2 = x1 - (fx1 * (x1 - x0)) / (fx1 - fx0);
        ER = (x2 - x1) / x2;
        if (fabs(ER) < E)
        {
            printf("Root=%f\n", x2);
            break;
        }
        x0 = x1;
        x1 = x2;
    }
    gettch();
}