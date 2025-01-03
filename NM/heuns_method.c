#include <stdio.h>
#include <conio.h>
#define f(x, y) (2 * y / x) // Define the given differential equation

int main()
{
    float x, xp, x0, y0, y, h, m1, m2;

    // Input initial values
    printf("Enter initial values of x and y (x0, y0):\n");
    scanf("%f %f", &x0, &y0);

    // Input x at which the function is to be evaluated
    printf("Enter the value of x at which function is to be evaluated:\n");
    scanf("%f", &xp);

    // Input step size
    printf("Enter the step size (h):\n");
    scanf("%f", &h);

    y = y0; // Initialize y with the initial condition
    x = x0; // Initialize x with the initial condition

    // Heun's Method
    while (x < xp)
    {
        m1 = f(x, y);                // Compute the slope at the start of the interval
        m2 = f(x + h, y + h * m1);   // Compute the predicted slope
        y = y + (h / 2) * (m1 + m2); // Update y using the average of the two slopes
        x = x + h;                   // Increment x by step size
    }

    // Output the result
    printf("Function value at x = %f is %f\n", x, y);

    getch();
    return 0;
}
