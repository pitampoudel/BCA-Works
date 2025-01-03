#include <stdio.h>
#include <conio.h>

int main()
{
    int n, i, j;
    float v = 0, p, xv, x[10], fx[10], a[10];

    printf("Enter the number of points: ");
    scanf("%d", &n);

    printf("Enter the value of x to interpolate: ");
    scanf("%f", &xv);

    for (i = 0; i < n; i++)
    {
        printf("Enter the value of x and f(x) at i = %d: ", i);
        scanf("%f%f", &x[i], &fx[i]);
    }

    // Copy initial y-values to divided difference array
    for (i = 0; i < n; i++)
    {
        a[i] = fx[i];
    }

    // Calculate divided differences
    for (i = 0; i < n; i++)
    {
        for (j = n - 1; j > i; j--)
        {
            a[j] = (a[j] - a[j - 1]) / (x[j] - x[j - 1 - i]);
        }
    }

    // Compute interpolation value
    for (i = 0; i < n; i++)
    {
        p = 1.0;
        for (j = 0; j < i; j++)
        {
            p *= (xv - x[j]);
        }
        v += a[i] * p;
    }

    printf("Interpolated value = %f\n", v);
    getch();
    return 0;
}
