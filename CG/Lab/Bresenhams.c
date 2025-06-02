#include <stdio.h>
#include<conio.h>
#include <graphics.h>

int main() {
    int gd = DETECT, gm;
    int x1, y1, x2, y2;

    printf("Enter x1 and y1: ");
    scanf("%d %d", &x1, &y1);
    printf("Enter x2 and y2: ");
    scanf("%d %d", &x2, &y2);

    initgraph(&gd, &gm, "");

    int dx = x2 - x1;
    int dy = y2 - y1;
    int x = x1;
    int y = y1;

    int p = 2 * dy - dx;

    while (x <= x2) {
        putpixel(x, y, BLUE);
        delay(50); 
        x = x + 1;

        if (p < 0) {
            p = p + 2 * dy;
        } else {
            y = y + 1;
            p = p + 2 * dy - 2 * dx;
        }
    }

    getch();
    closegraph();
    return 0;
}
