#include <stdio.h>

// Define the clipping window boundaries
const int X_MIN = 50;
const int X_MAX = 250;
const int Y_MIN = 50;
const int Y_MAX = 150;

// Define region codes
const int INSIDE = 0; // 0000
const int LEFT = 1;   // 0001
const int RIGHT = 2;  // 0010
const int BOTTOM = 4; // 0100
const int TOP = 8;    // 1000

// Function to compute region code for a point
int computeRegionCode(int x, int y) {
    int code = INSIDE;
    if (x < X_MIN)
        code |= LEFT;
    else if (x > X_MAX)
        code |= RIGHT;
    if (y < Y_MIN)
        code |= BOTTOM;
    else if (y > Y_MAX)
        code |= TOP;
    return code;
}

// Cohen-Sutherland line clipping algorithm
void cohenSutherlandClip(int *x1, int *y1, int *x2, int *y2) {
    int code1 = computeRegionCode(*x1, *y1);
    int code2 = computeRegionCode(*x2, *y2);
    
    bool accept = false;

    while (true) {
        if ((code1 == 0) && (code2 == 0)) {
            // Both endpoints are inside the clipping window
            accept = true;
            break;
        } else if (code1 & code2) {
            // Both endpoints are outside a common boundary
            break;
        } else {
            // The line needs clipping
            int codeOut = code1 ? code1 : code2;
            double x, y;

            // Find intersection point
            if (codeOut & TOP) {
                x = *x1 + (*x2 - *x1) * (Y_MAX - *y1) / (double)(*y2 - *y1);
                y = Y_MAX;
            } else if (codeOut & BOTTOM) {
                x = *x1 + (*x2 - *x1) * (Y_MIN - *y1) / (double)(*y2 - *y1);
                y = Y_MIN;
            } else if (codeOut & RIGHT) {
                y = *y1 + (*y2 - *y1) * (X_MAX - *x1) / (double)(*x2 - *x1);
                x = X_MAX;
            } else if (codeOut & LEFT) {
                y = *y1 + (*y2 - *y1) * (X_MIN - *x1) / (double)(*x2 - *x1);
                x = X_MIN;
            }
            
            // Update the endpoint and its code
            if (codeOut == code1) {
                *x1 = x;
                *y1 = y;
                code1 = computeRegionCode(*x1, *y1);
            } else {
                *x2 = x;
                *y2 = y;
                code2 = computeRegionCode(*x2, *y2);
            }
        }
    }
    if (accept) {
        printf("Line accepted from (%d, %d) to (%d, %d)\n", *x1, *y1, *x2, *y2);
    } else {
         printf("Line rejected\n");
    }
}

int main() {
    int x1, y1, x2, y2;

    printf("Enter the coordinates of the first point (x1 y1): ");
    scanf("%d %d", &x1, &y1);
    printf("Enter the coordinates of the second point (x2 y2): ");
    scanf("%d %d", &x2, &y2);
    
    printf("Clipping window: (%d, %d) to (%d, %d)\n", X_MIN, Y_MIN, X_MAX, Y_MAX);
    printf("Original line: (%d, %d) to (%d, %d)\n", x1, y1, x2, y2);
    
    cohenSutherlandClip(&x1, &y1, &x2, &y2);

    return 0;
}
