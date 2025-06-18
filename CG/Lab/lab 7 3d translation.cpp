#include <graphics.h>
#include <stdio.h>

// 3D point structure
typedef struct {
    float x, y, z;
} Point3D;

// Cube vertices
Point3D cube[8] = {
    {-50, -50, -50}, {50, -50, -50}, {50, 50, -50}, {-50, 50, -50},
    {-50, -50, 50},  {50, -50, 50},  {50, 50, 50},  {-50, 50, 50}
};

// Faces (indices)
int faces[6][4] = {
    {0, 1, 2, 3},  // Back
    {4, 5, 6, 7},  // Front
    {0, 1, 5, 4},  // Bottom
    {2, 3, 7, 6},  // Top
    {1, 2, 6, 5},  // Right
    {0, 3, 7, 4}   // Left
};

// Orthographic projection
void project(Point3D p, int *x, int *y) {
    *x = 320 + (int)p.x;
    *y = 240 - (int)p.y;
}

// Draw cube edges
void drawCube(Point3D points[]) {
    int i, j;
    for (i = 0; i < 6; i++) {
        int px[4], py[4];
        for (j = 0; j < 4; j++) {
            project(points[faces[i][j]], &px[j], &py[j]);
        }
        // Draw edges of face
        for (j = 0; j < 4; j++) {
            line(px[j], py[j], px[(j+1)%4], py[(j+1)%4]);
        }
    }
}

// Translate the cube by dx, dy, dz
void translate(Point3D points[], float dx, float dy, float dz) {
    for (int i = 0; i < 8; i++) {
        points[i].x += dx;
        points[i].y += dy;
        points[i].z += dz;
    }
}

int main() {
		printf("Saudeep Adhikari\n");

    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");

    Point3D translatedCube[8];

    // Copy original cube to translatedCube
    for (int i = 0; i < 8; i++) {
        translatedCube[i] = cube[i];
    }

    // Translate cube by (100, 50, 0)
    translate(translatedCube, 100, 50, 0);

    drawCube(translatedCube);

    getch();
    closegraph();
    return 0;
}
