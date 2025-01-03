#include <stdio.h>
#include <conio.h>

int main()
{
    int n, i;
    float x[100], y[100], sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
    float slope, intercept;

    printf("Enter the number of data points: ");
    scanf("%d", &n);

    printf("Enter the values of x and y:\n");
    for (i = 0; i < n; i++)
    {
        printf("x[%d], y[%d]: ", i, i);
        scanf("%f%f", &x[i], &y[i]);
        sumX += x[i];
        sumY += y[i];
        sumXY += x[i] * y[i];
        sumX2 += x[i] * x[i];
    }

    // Calculate slope and intercept
    slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
    intercept = (sumY - slope * sumX) / n;

    printf("\nThe Linear Regression Line is: y = %.2fx + %.2f\n", slope, intercept);

    getch();
    return 0;
}
