#include <stdio.h>
#include <conio.h>
#include <math.h>
#define f(x, y) 2 * (x) + (y)
int main()
{
    float x, xp, x0, y0, y, h, m1, m2, m3, m4;
    printf("Enter initial values of x and y\n");
    scanf("%f%f", &x0, y0);
    printf("Enter x at which function to be evaluated\n");
    scanf("%f", &xp);
    printf("Enter the step size\n");
    scanf("%f", &h);
    y = y0;
    x = x0;
    for (x = x0; x < xp; x = x + h)
    {
        m1 = f(x, y);
        m2 = f(x + 1 / 2 * h, y + 1 / 2 * h * m1);
        m3 = f(x + 1 / 2 * h, y + 1 / 2 * h * m2);
        m4 = f(x + h, y + h * m3);
        y = y + h / 6 * (m1 + 2 * m2 + 2 * m3 + m4);
    }
    printf("function value at x=%f is %f\n", xp, y);
    getch();
    // return 0;
}