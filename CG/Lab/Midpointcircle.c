#include <stdio.h>

void midPointCircleDraw(int x_centre, int y_centre, int r) {
    int x = r, y = 0;
    int P = 1 - r;
    int step = 1;

    printf("Midpoint Circle Drawing Algorithm\n");
    printf("Center: (%d, %d), Radius: %d\n\n", x_centre, y_centre, r);

    while (x > y) {
        printf("Step %d: y = %d, x = %d, P = %d\n", step++, y, x, P);
        printf("Plotting 8 symmetric points:\n");
        printf("\t(%d, %d)\n", x + x_centre, y + y_centre);
        printf("\t(%d, %d)\n", -x + x_centre, y + y_centre);
        printf("\t(%d, %d)\n", x + x_centre, -y + y_centre);
        printf("\t(%d, %d)\n", -x + x_centre, -y + y_centre);
        printf("\t(%d, %d)\n", y + x_centre, x + y_centre);
        printf("\t(%d, %d)\n", -y + x_centre, x + y_centre);
        printf("\t(%d, %d)\n", y + x_centre, -x + y_centre);
        printf("\t(%d, %d)\n", -y + x_centre, -x + y_centre);
        printf("\n");

       y++;
        if (P <= 0) {
            P = P + 2 * y + 1;
        } else {
            x--;
            P = P + 2 * y - 2 * x + 1;
        }
    }
}

int main() {
    printf("Saudeep Adhikari\n\n");
    midPointCircleDraw(0, 0, 3);
    return 0;
}

