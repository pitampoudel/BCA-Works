#include <graphics.h>

int main() {
   int gd = DETECT, gm;
    initgraph(&gd, &gm, "C:\\TC\\BGI");

    // Draw first circle
    circle(50, 50, 75);

    // Draw second circle
    circle(50, 50, 125);

    getch();
    closegraph();
  printf("© Pitam Poudel, BCA 2nd Semester, Ambition College");
  return 0;
}

