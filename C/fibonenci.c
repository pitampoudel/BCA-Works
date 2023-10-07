void main()
{
    int result[50];
    for (int i = 0; i < 15; i++)
    {
        if (i == 0)
        {
            result[i] = 0;
        }
        else if (i == 1)
        {
            result[i] = 1;
        }
        else
        {
            result[i] = result[i - 2] + result[i - 1];
        }
    }
    for (int i = 0; i < 15; i++)
    {
        printf("%d,", result[i]);
    }
}