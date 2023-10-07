#include <stdio.h>
#include <stdlib.h>
void main()
{
    fopen_with_r();
    fopen_with_r_plus();
    fopen_with_w();
    fopen_with_w_plus();
    fopen_with_a();
    fopen_with_a_plus();
}

/**
 * Open for both reading and writing
 * If the file does not exist, fopen() returns NULL
 */
void fopen_with_r_plus()
{
    FILE *fp;
    fp = fopen("test.txt", "r+");
    fputs("fopen_with_r_plus test", fp);
    fclose(fp);
    print_test_file();
}

/**
 * Open for writing
 * If the file exists, its contents are overwritten.
 * If the file does not exist, it will be created.
 */
void fopen_with_w()
{
    FILE *fp;
    fp = fopen("test.txt", "w");
    fputs("fopen_with_w test", fp);
    fclose(fp);
    print_test_file();
}

/*
 * Open for both reading and writing
 * If the file exists, its contents are overwritten.
 * If the file does not exist, it will be created.
 */
void fopen_with_w_plus()
{
    FILE *fp;
    fp = fopen("test.txt", "w+");
    fputs("fopen_with_w_plus test", fp);
    fclose(fp);
    print_test_file();
}

/**
 * Open for append.
 * Data is added to the end of the file
 * If the file does not exist, it will be created.
 */
void fopen_with_a()
{
    FILE *fp;
    fp = fopen("test.txt", "a");
    fputs("fopen_with_a test", fp);
    fclose(fp);
    print_test_file();
}

/**
 * Open for both reading and appending
 * If the file does not exist, it will be created
 */
void fopen_with_a_plus()
{
    FILE *fp;
    fp = fopen("test.txt", "a+");
    fputs("fopen_with_a_plus test", fp);
    fclose(fp);
    print_test_file();
}

/*
 * Open for reading
 * If the file does not exist, fopen() returns NULL
 */
void fopen_with_r()
{
    print_test_file();
}

void print_test_file()
{
    FILE *fp;
    fp = fopen("test.txt", "r");
    char file_content[200];
    fgets(file_content, 200, fp);
    printf(file_content);
    fclose(fp);
}