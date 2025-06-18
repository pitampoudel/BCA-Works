#include <stdio.h>
#include <math.h>

// Function to rotate a point (x, y) around the origin (0,0) by angle theta (in radians)
void rotatePoint(float *x, float *y, float theta) {
    float x_new = (*x) * cos(theta) - (*y) * sin(theta);
    float y_new = (*x) * sin(theta) + (*y) * cos(theta);
    *x = x_new;
    *y = y_new;
}

int main() {
    float x, y, angle_degrees;
	printf("© 2025 Pitam Poudel. All rights reserved.\n");
    // Get input from user
    printf("Enter the x-coordinate: ");
    scanf("%f", &x);
    
    printf("Enter the y-coordinate: ");
    scanf("%f", &y);
    
    printf("Enter rotation angle in degrees: ");
    scanf("%f", &angle_degrees);

    // Convert degrees to radians
    float angle_radians = angle_degrees * M_PI / 180.0;

    // Print original coordinates
    printf("\nOriginal Coordinates: (%.2f, %.2f)\n", x, y);

    // Rotate the point
    rotatePoint(&x, &y, angle_radians);

    // Print rotated coordinates
    printf("Rotated Coordinates: (%.2f, %.2f)\n", x, y);

    return 0;
}

