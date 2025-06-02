//Not running
#include <graphics.h>
#include <stdio.h>
#include <math.h>
#include <conio.h>

#define PI 3.1416

typedef struct {
    float x, y, z;
} Point3D;

Point3D cube[8] = {
    {-100, -100, -100}, {100, -100, -100}, {100, 100, -100}, {-100, 100, -100},
    {-100, -100, 100},  {100, -100, 100},  {100, 100, 100},  {-100, 100, 100}
};

int faces[6][4] = {
    {0, 1, 2, 3}, {4, 5, 6, 7}, {0, 1, 5, 4},
    {2, 3, 7, 6}, {1, 2, 6, 5}, {0, 3, 7, 4}
};

void project(Point3D p, int *x, int *y) {
    *x = 320 + (int)p.x;
    *y = 240 - (int)p.y;
}

Point3D crossProduct(Point3D a, Point3D b) {
    Point3D c;
    c.x = a.y * b.z - a.z * b.y;
    c.y = a.z * b.x - a.x * b.z;
    c.z = a.x * b.y - a.y * b.x;
    return c;
}

Point3D vector(Point3D a, Point3D b) {
    Point3D v = {b.x - a.x, b.y - a.y, b.z - a.z};
    return v;
}

float dotProduct(Point3D a, Point3D b) {
    return a.x * b.x + a.y * b.y + a.z * b.z;
}

void drawCube(Point3D cube[]) {
    for (int i = 0; i < 6; i++) {
        Point3D a = cube[faces[i][0]];
        Point3D b = cube[faces[i][1]];
        Point3D c = cube[faces[i][2]];

        Point3D ab = vector(a, b);
        Point3D ac = vector(a, c);
        Point3D normal = crossProduct(ab, ac);
        Point3D view = {0, 0, -1};

        if (dotProduct(normal, view) <= 0)
            continue;

        int pts[8];
        for (int j = 0; j < 4; j++) {
            int x, y;
            project(cube[faces[i][j]], &x, &y);
            pts[j * 2] = x;
            pts[j * 2 + 1] = y;
        }

        setfillstyle(SOLID_FILL, i + 1);
        fillpoly(4, pts);
    }
}

void rotateY(Point3D *p, float angle) {
    float rad = angle * PI / 180;
    float x = p->x * cos(rad) - p->z * sin(rad);
    float z = p->x * sin(rad) + p->z * cos(rad);
    p->x = x;
    p->z = z;
}

int main() {
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "C:\\TURBOC3\\BGI");

    while (!kbhit()) {
        cleardevice();

        Point3D temp[8];
        for (int i = 0; i < 8; i++)
            temp[i] = cube[i];

        for (int i = 0; i < 8; i++)
            rotateY(&temp[i], 3);

        drawCube(temp);
        delay(100);
    }

    getch();
    closegraph();
    return 0;
}

