#include <stdio.h>

void areaOfSquare(int length)
{
    printf("area is %d ", length * length);
  
}

void perimeterOfSquare(int length)
{
    printf("perimeter is %d ", length * 4);
}

void main()
{
    int len;
    printf("enter length of square \n");
    scanf("%d", &len);
    areaOfSquare(len);
    perimeterOfSquare(len);
}
