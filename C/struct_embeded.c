void main()
{
    struct News
    {
        char title[50];
        struct Category
        {
            int id;
            char title[50];
        } category;
    };
}