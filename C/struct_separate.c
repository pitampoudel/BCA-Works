void main()
{
    struct Category
    {
        int id;
        char title[50];
    };

    struct News
    {
        char title[50];
        struct Category Category;
    };
}