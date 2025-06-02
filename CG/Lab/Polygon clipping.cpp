//polygon cohensutterland
#include <graphics.h>
#include <stdio.h>

#define MAX 20

// Clipping rectangle
int xmin = 100, ymin = 100, xmax = 300, ymax = 300;

void drawPolygon(int poly[][2], int n, int color) {
    setcolor(color);
    for (int i = 0; i < n; i++) {
        int x1 = poly[i][0], y1 = poly[i][1];
        int x2 = poly[(i + 1) % n][0], y2 = poly[(i + 1) % n][1];
        line(x1, y1, x2, y2);
    }
}

// Check if point is inside based on clipping edge
int inside(int x, int y, int edge) {
    switch (edge) {
        case 0: return x >= xmin;  // Left
        case 1: return x <= xmax;  // Right
        case 2: return y >= ymin;  // Bottom
        case 3: return y <= ymax;  // Top
    }
    return 0;
}

// Compute intersection with clipping boundary
void intersect(int x1, int y1, int x2, int y2, int edge, int *xi, int *yi) {
    float m = (x2 != x1) ? (float)(y2 - y1) / (x2 - x1) : 0;

    switch (edge) {
        case 0: // Left
            *xi = xmin;
            *yi = y1 + (xmin - x1) * m;
            break;
        case 1: // Right
            *xi = xmax;
            *yi = y1 + (xmax - x1) * m;
            break;
        case 2: // Bottom
            *yi = ymin;
            *xi = (m != 0) ? x1 + (ymin - y1) / m : x1;
            break;
        case 3: // Top
            *yi = ymax;
            *xi = (m != 0) ? x1 + (ymax - y1) / m : x1;
            break;
    }
}

// Clip polygon against one edge
void clipEdge(int edge, int inPoly[][2], int *inCount, int outPoly[][2], int *outCount) {
    *outCount = 0;
    for (int i = 0; i < *inCount; i++) {
        int x1 = inPoly[i][0], y1 = inPoly[i][1];
        int x2 = inPoly[(i + 1) % *inCount][0], y2 = inPoly[(i + 1) % *inCount][1];

        int in1 = inside(x1, y1, edge);
        int in2 = inside(x2, y2, edge);

        if (in1 && in2) {
            outPoly[(*outCount)][0] = x2;
            outPoly[(*outCount)++][1] = y2;
        } else if (in1 && !in2) {
            int xi, yi;
            intersect(x1, y1, x2, y2, edge, &xi, &yi);
            outPoly[(*outCount)][0] = xi;
            outPoly[(*outCount)++][1] = yi;
        } else if (!in1 && in2) {
            int xi, yi;
            intersect(x1, y1, x2, y2, edge, &xi, &yi);
            outPoly[(*outCount)][0] = xi;
            outPoly[(*outCount)++][1] = yi;
            outPoly[(*outCount)][0] = x2;
            outPoly[(*outCount)++][1] = y2;
        }
    }
}

int main() {
	printf("Saudeep Adhikari\n");
    int gd = DETECT, gm;
    initgraph(&gd, &gm, "");

    int poly[20][2], n;
    printf("Enter number of vertices: ");
    scanf("%d", &n);

    printf("Enter vertices (x y):\n");
    for (int i = 0; i < n; i++)
        scanf("%d %d", &poly[i][0], &poly[i][1]);

    // Draw clipping window
    setcolor(YELLOW);
    rectangle(xmin, ymin, xmax, ymax);

    // Draw original polygon
    drawPolygon(poly, n, WHITE);

    int outPoly[20][2], outCount;
    int tempPoly[20][2], tempCount = n;

    for (int i = 0; i < n; i++) {
        tempPoly[i][0] = poly[i][0];
        tempPoly[i][1] = poly[i][1];
    }

    // Clip against all 4 edges
    for (int edge = 0; edge < 4; edge++) {
        clipEdge(edge, tempPoly, &tempCount, outPoly, &outCount);

        for (int i = 0; i < outCount; i++) {
            tempPoly[i][0] = outPoly[i][0];
            tempPoly[i][1] = outPoly[i][1];
        }
        tempCount = outCount;
    }

    // Draw final clipped polygon
    drawPolygon(outPoly, outCount, GREEN);

    getch();
    closegraph();
    return 0;
}
