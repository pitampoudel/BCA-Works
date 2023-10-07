void display(int result[][10], int row, int column)
{
    for (int i = 0; i <= row; ++i)
    {
        for (int j = 0; j <= column; ++j)
        {
            printf("%d  ", result[i][j]);
        }
        printf("\n");
    }
}

void main()
{
    // Assign values to array a
    int a[2][2];
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {
            printf("enter value for a[%d][%d] : ", i, j);
            scanf("%d", &a[i][j]);
        }
    }

    // Assign values to array b
    int b[2][2];
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {
            printf("enter value for b[%d][%d] : ", i, j);
            scanf("%d", &b[i][j]);
        }
    }

    // Print current values
    printf("\n\nMatrix a\n");
    display(a, 2, 2);
    printf("\n\nMatrix b\n");
    display(b, 2, 2);

    int result[2][2];

    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {

            for (int k = 0; k <= 2; k++)
            {

                result[i][j] += a[i][k] * b[k][j];
            }
        }
    }

    printf("\n\nResult Matrix\n");
    display(result, 2, 2);
}