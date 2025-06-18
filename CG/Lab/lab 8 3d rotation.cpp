#include <graphics.h>
#include <math.h>
#include <stdio.h>

#define PI 3.14159265

// Structure for 3D point
typedef struct {
    float x, y, z;
} Point3D;

// Project 3D point to 2D (simple orthographic projection)
void project(Point3D p, int* x, int* y) {
    *x = 320 + p.x;
    *y = 240 - p.y;
}

// Rotate a point around X axis
void rotateX(Point3D* p, float angle) {
    float rad = angle * PI / 180;
    float y = p->y;
    float z = p->z;
    p->y = y * cos(rad) - z * sin(rad);
    p->z = y * sin(rad) + z * cos(rad);
}

// Rotate a point around Y axis
void rotateY(Point3D* p, float angle) {
    float rad = angle * PI / 180;
    float x = p->x;
    float z = p->z;
    p->x = x * cos(rad) + z * sin(rad);
    p->z = -x * sin(rad) + z * cos(rad);
}

// Rotate a point around Z axis
void rotateZ(Point3D* p, float angle) {
    float rad = angle * PI / 180;
    float x = p->x;
    float y = p->y;
    p->x = x * cos(rad) - y * sin(rad);
    p->y = x * sin(rad) + y * cos(rad);
}

// Draw a line between two 3D points after projecting them to 2D
void drawLine3D(Point3D a, Point3D b) {
    int x1, y1, x2, y2;
    project(a, &x1, &y1);
    project(b, &x2, &y2);
    line(x1, y1, x2, y2);
}

int main() {
	printf("© 2025 Pitam Poudel. All rights reserved.\n");
    // Define a cube with 8 vertices
    Point3D cube[8] = {
        {-50, -50, -50}, {50, -50, -50},
        {50, 50, -50}, {-50, 50, -50},
        {-50, -50, 50}, {50, -50, 50},
        {50, 50, 50}, {-50, 50, 50}
    };

    float angleX, angleY, angleZ;

    printf("Enter rotation angle about X-axis: ");
    scanf("%f", &angleX);
    printf("Enter rotation angle about Y-axis: ");
    scanf("%f", &angleY);
    printf("Enter rotation angle about Z-axis: ");
    scanf("%f", &angleZ);

    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");
    
    // Apply rotation to all cube vertices
    for (int i = 0; i < 8; i++) {
        rotateX(&cube[i], angleX);
        rotateY(&cube[i], angleY);
        rotateZ(&cube[i], angleZ);
    }

    // Draw cube edges
    drawLine3D(cube[0], cube[1]);
    drawLine3D(cube[1], cube[2]);
    drawLine3D(cube[2], cube[3]);
    drawLine3D(cube[3], cube[0]);

    drawLine3D(cube[4], cube[5]);
    drawLine3D(cube[5], cube[6]);
    drawLine3D(cube[6], cube[7]);
    drawLine3D(cube[7], cube[4]);

    drawLine3D(cube[0], cube[4]);
    drawLine3D(cube[1], cube[5]);
    drawLine3D(cube[2], cube[6]);
    drawLine3D(cube[3], cube[7]);

    getch();
    closegraph();
    return 0;
}
