#include <stdio.h>
#include <conio.h>
#include <math.h>

// Function to integrate
float f(float x)
{
    return 1 / (1 + x * x); // Example: f(x) = 1 / (1 + x^2)
}

int main()
{
    float a, b, h, sum = 0.0;
    int n, i;

    printf("Enter the lower limit (a): ");
    scanf("%f", &a);
    printf("Enter the upper limit (b): ");
    scanf("%f", &b);
    printf("Enter the number of sub-intervals (n, must be multiple of 3): ");
    scanf("%d", &n);

    // Ensure n is a multiple of 3
    if (n % 3 != 0)
    {
        printf("Error: n must be a multiple of 3.\n");
        return 1;
    }

    h = (b - a) / n; // Calculate step size

    // Apply Simpson's 3/8 Rule
    sum = f(a) + f(b); // First and last terms
    for (i = 1; i < n; i++)
    {
        if (i % 3 == 0)
            sum += 2 * f(a + i * h); // Multiply by 2 for every 3rd interval
        else
            sum += 3 * f(a + i * h); // Multiply by 3 for other intervals
    }
    sum *= (3 * h / 8); // Multiply by the final factor

    printf("The value of the integral is: %f\n", sum);

    getch();
    return 0;
}
