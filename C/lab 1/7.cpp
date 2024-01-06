#include <stdio.h>

int main() {
    double principal, time, rate, simple_interest;
    
    // Input principal, time, and rate of interest
    printf("Enter the principal amount (p): ");
    scanf("%lf", &principal);
    
    printf("Enter the time (t) in years: ");
    scanf("%lf", &time);
    
    printf("Enter the rate of interest (r) in percentage: ");
    scanf("%lf", &rate);

    // Calculate simple interest
    simple_interest = (principal * time * rate) / 100.0;
    
    // Display the result
    printf("Simple Interest (SI): %.2lf\n", simple_interest);

    return 0;
}






