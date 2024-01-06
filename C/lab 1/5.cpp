//Name: Dhiraj Dhungel
//Level: 2nd Semester BCA, TU | Ambition Academy

#include <stdio.h>
#include<math.h>

int main() {
    float num1, num2;
    
    // Input two floating-point numbers
    printf("Enter the first floating-point number: ");
    scanf("%f", &num1);
    
    printf("Enter the second floating-point number: ");
    scanf("%f", &num2);

    // Calculate and display results
    float sum = num1 + num2;
    float difference = num1 - num2;
    float product = num1 * num2;
    
    // Check for division by zero
    if (num2 != 0) {
        float division = num1 / num2;
        float modulus = fmod(num1, num2);
        
        printf("Sum: %.2f\n", sum);
        printf("Difference: %.2f\n", difference);
        printf("Product: %.2f\n", product);
        printf("Division: %.2f\n", division);
        printf("Modulus: %.2f\n", modulus);
    } else {
        printf("Division and Modulus cannot be calculated because the second number is zero.\n");
    }

    return 0;
}






