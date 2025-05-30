#include <graphics.h>
#include <conio.h>
#include <math.h>
#include <stdlib.h>

// LAB 3
void bresenhamLine(int x0, int y0, int x1, int y1) {
    int dx = abs(x1 - x0);
    int dy = abs(y1 - y0);
    
    int sx = (x0 < x1) ? 1 : -1;
    int sy = (y0 < y1) ? 1 : -1;
    
    int err = dx - dy;

    while (1) {
        putpixel(x0, y0, WHITE);

        if (x0 == x1 && y0 == y1)
            break;

        int e2 = 2 * err;

        if (e2 > -dy) {
            err -= dy;
            x0 += sx;
        }

        if (e2 < dx) {
            err += dx;
            y0 += sy;
        }
    }
}

int main() {
    int gd = DETECT, gm;

    initgraph(&gd, &gm, "");  // Initialize graphics mode

    int x0 = 100, y0 = 100;
    int x1 = 300, y1 = 200;

    bresenhamLine(x0, y0, x1, y1);

    getch();  // Wait for key press
    closegraph();  // Close graphics window

    return 0;
}

