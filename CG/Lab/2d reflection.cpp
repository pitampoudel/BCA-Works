#include <graphics.h>
#include <stdio.h>

// Function to draw a triangle given arrays of x and y points
void drawTriangle(int x[], int y[]) {
    line(x[0], y[0], x[1], y[1]);
    line(x[1], y[1], x[2], y[2]);
    line(x[2], y[2], x[0], y[0]);
}

// Reflect triangle about x-axis (y -> -y)
void reflectX(int x[], int y[], int n, int centerY) {
    for (int i = 0; i < n; i++) {
        y[i] = 2 * centerY - y[i];
    }
}

// Reflect triangle about line y = x (swap x and y)
void reflectYeqX(int x[], int y[], int n) {
    for (int i = 0; i < n; i++) {
        int temp = x[i];
        x[i] = y[i];
        y[i] = temp;
    }
}

int main() {
		printf("Saudeep Adhikari\n");

    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");

    int x[3], y[3];

    // Original triangle points
    x[0] = 200; y[0] = 200;
    x[1] = 300; y[1] = 200;
    x[2] = 250; y[2] = 100;

    // Draw original triangle in WHITE
    drawTriangle(x, y);

    // Reflect about x-axis (assuming x-axis at y=200 for demonstration)
    int x_reflectX[3], y_reflectX[3];
    for (int i = 0; i < 3; i++) {
        x_reflectX[i] = x[i];
        y_reflectX[i] = y[i];
    }
    reflectX(x_reflectX, y_reflectX, 3, 200);
    setcolor(RED);
    drawTriangle(x_reflectX, y_reflectX);

    // Reflect about line y = x
    int x_reflectYeqX[3], y_reflectYeqX[3];
    for (int i = 0; i < 3; i++) {
        x_reflectYeqX[i] = x[i];
        y_reflectYeqX[i] = y[i];
    }
    reflectYeqX(x_reflectYeqX, y_reflectYeqX, 3);
    setcolor(GREEN);
    drawTriangle(x_reflectYeqX, y_reflectYeqX);

    getch();
    closegraph();
    return 0;
}
