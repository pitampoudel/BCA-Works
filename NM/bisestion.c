#include <stdio.h>
#include <conio.h>

int a0, a1, a2, a3;
float f(float x)
{
    return (a3 * x * x * x + a2 * x * x + a1 * x + a0);
}

int main()
{
    float xl, xu, xm, fxl, fxu, fxm, E, ER;

    printf("Pitam Poudel\n");
    printf("Enter coefficients a3, a2, a1, a0: ");
    scanf("%d%d%d%d", &a3, &a2, &a1, &a0);
    printf("Enter initial guesses xl, xu and tolerance E: ");
    scanf("%f%f%f", &xl, &xu, &E);

    while (1)
    {
        fxl = f(xl);
        fxu = f(xu);
        xm = (xl + xu) / 2;
        fxm = f(xm);

        if (fxm == 0 || (xu - xl) / 2 < E)
        {
            printf("Root = %f\n", xm);
            break;
        }

        if (fxl * fxm < 0)
        {
            xu = xm;
        }
        else
        {
            xl = xm;
        }
    }

    getch();
    return 0;
}
