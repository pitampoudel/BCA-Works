#include <stdio.h> 
// Function to scale a point (x,y) around the origin (0,0) by scale factors sx and sy 
void scalePoint(float *x, float *y, float sx, float sy) { 
	*x = (*x) * sx; 
	*y = (*y) * sy; 
} 

int main() { 
	float x, y, scale_x, scale_y;
	printf("© 2025 Pitam Poudel. All rights reserved.\n");
	 
	// Get input from user 
	printf("Enter the x-coordinate: ");
	scanf("%f", &x);
	     
	printf("Enter the y-coordinate: "); 
	scanf("%f", &y);
	     
	printf("Enter scale factor for x: "); 
	scanf("%f", &scale_x);
	   
	printf("Enter scale factor for y: "); 
	scanf("%f", &scale_y);
	 
	// Print original coordinates 	
	printf("\nOriginal Coordinates: (%.2f, %.2f)\n", x, y); 
	
	// Scale the point 
	scalePoint(&x, &y, scale_x, scale_y);
	 
	// Print scaled coordinates 
	printf("Scaled Coordinates: (%.2f, %.2f)\n", x, y); 
	return 0; 
}
