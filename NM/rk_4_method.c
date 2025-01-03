#include <stdio.h>
#include <conio.h>
#define f(x, y) (2 * (x) + (y)) // Define the given differential equation

int main()
{
    float x, xp, x0, y0, y, h, m1, m2, m3, m4;

    // Input initial values
    printf("Enter initial values of x and y (x0, y0):\n");
    scanf("%f%f", &x0, &y0);

    // Input x at which the function is to be evaluated
    printf("Enter the value of x at which the function is to be evaluated:\n");
    scanf("%f", &xp);

    // Input step size
    printf("Enter the step size (h):\n");
    scanf("%f", &h);

    y = y0; // Initialize y with the initial condition
    x = x0; // Initialize x with the initial condition

    // Runge-Kutta 4th Order Method
    while (x < xp)
    {
        m1 = f(x, y);                                  // Compute the first slope
        m2 = f(x + h / 2, y + (h / 2) * m1);           // Compute the second slope
        m3 = f(x + h / 2, y + (h / 2) * m2);           // Compute the third slope
        m4 = f(x + h, y + h * m3);                     // Compute the fourth slope
        y = y + (h / 6) * (m1 + 2 * m2 + 2 * m3 + m4); // Update y
        x = x + h;                                     // Increment x by step size
    }

    // Output the result
    printf("Function value at x = %f is %f\n", xp, y);

    getch();
    return 0;
}
