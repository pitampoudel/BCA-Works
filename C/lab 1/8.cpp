#include <stdio.h>

int main() {
    float marks;
    
    // Input marks
    printf("Enter your marks: ");
    scanf("%f", &marks);
    
    // Check if marks are greater than or equal to 65
    if (marks >= 65) {
        // Increase marks by 10%
        marks = marks + (0.10 * marks);
    }
    
    // Print the result
    printf("Updated marks: %.2f\n", marks);

    return 0;
}



