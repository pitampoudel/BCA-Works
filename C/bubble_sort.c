#include <stdio.h>

int main(){
    int numbers[10], temp;

    for (int i = 0; i < 10; i++){
        printf("enter number for index %d\n", i);
        scanf("%d", &numbers[i]);
    }

    for (int i = 0; i < 10; i++) {
        for (int j = i + 1; j < 10; j++)  {
            if (numbers[j] < numbers[i])   {
                temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }

    for (int i = 0; i < 10; i++)  {
        printf("value at index %d is %d\n", i, numbers[i]);
    }

    return 0;
}