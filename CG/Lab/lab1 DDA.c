#include <graphics.h>
#include <iostream>
#include <cmath>

int main() {
		printf("Saudeep Adhikari\n");

    int gd = DETECT, gm;
    int x1, y1, x2, y2, dx, dy, steps, i;
    float x, y, x_inc, y_inc;

    // Initialize graphics
    initgraph(&gd, &gm, "");

    // Input coordinates
    std::cout << "Enter starting coordinates (x1 y1): ";
    std::cin >> x1 >> y1;
    std::cout << "Enter ending coordinates (x2 y2): ";
    std::cin >> x2 >> y2;

    dx = x2 - x1;
    dy = y2 - y1;

    steps = std::max(abs(dx), abs(dy));

    x_inc = dx / (float)steps;
    y_inc = dy / (float)steps;

    x = x1;
    y = y1;

    for (i = 0; i <= steps; i++) {
        putpixel((int)round(x), (int)round(y), RED);
        x += x_inc;
        y += y_inc;
        delay(50);
    }

    getch();
    closegraph();
    return 0;
}

