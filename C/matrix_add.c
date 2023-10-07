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
    printf("\nCurrent values are\n");
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {
            printf("a[%d][%d] = %d & b[%d][%d] = %d\n", i, j, a[i][j], i, j, b[i][j]);
        }
    }

    // Add each element of b to that of a
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {
            a[i][j] += b[i][j];
        }
    }

    // Print current values
    printf("\nCurrent values are\n");
    for (int i = 0; i <= 2; i++)
    {
        for (int j = 0; j <= 2; j++)
        {
            printf("a[%d][%d] = %d & b[%d][%d] = %d\n", i, j, a[i][j], i, j, b[i][j]);
        }
    }
}