#include <stdio.h>

#define EPSILON 0.01

// x^3 - x^2 + 2
double func(double x)
{
    return x * x * x - x * x + 2;
}

// Prints root of func(x) with error of EPSILON
void bisection(double a, double b)
{
    if (func(a) * func(b) >= 0)
    {
        printf("You have not assumed right a and b\n");
        return;
    }

    double c = a;
    while ((b - a) >= EPSILON)
    {
        // Find middle point
        c = (a + b) / 2;

        // Check if middle point is root
        if (func(c) == 0.0)
            break;

        // Decide the side to repeat the steps
        else if (func(c) * func(a) < 0)
            b = c;
        else
            a = c;
    }
    printf("The value of root is : %d", c);
}

int main()
{
    // Initial range assumed
    bisection(-200, 300);
    return 0;
}
