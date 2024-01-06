#include <stdio.h>

int main() {
    double length, breadth;
    
    // Input the length and breadth
    printf("Enter the length of the rectangle: ");
    scanf("%lf", &length);
    
    printf("Enter the breadth of the rectangle: ");
    scanf("%lf", &breadth);

    // Calculate area and perimeter
    double area = length * breadth;
    double perimeter = 2 * (length + breadth);
    
    // Display the results
    printf("Area of the rectangle: %.2lf square units\n", area);
    printf("Perimeter of the rectangle: %.2lf units\n", perimeter);

    return 0;
}

