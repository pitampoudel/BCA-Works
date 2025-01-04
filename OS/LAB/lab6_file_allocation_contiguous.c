#include <stdio.h>
#include <stdlib.h>

#define MAX_BLOCKS 10
#define MAX_FILES 3

// Contiguous Allocation Method
void contiguousAllocation(int blocks[], int fileSizes[], int nFiles)
{
    printf("Contiguous Allocation\n");
    int i;
    for (i = 0; i < nFiles; i++)
    {
        printf("\nFile %d:", i + 1);
        int fileSize = fileSizes[i];

        // Find a contiguous block that can accommodate the file
        int j;
        for (j = 0; j < MAX_BLOCKS; j++)
        {
            if (blocks[j] == 0)
            {
                int count = 0, k;

                // Try to allocate contiguous blocks
                for (k = j; k < MAX_BLOCKS && count < fileSize; k++)
                {
                    if (blocks[k] == 0)
                    {
                        blocks[k] = i + 1; // Allocate block
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }

                if (count == fileSize)
                {
                    printf("\nAllocated file %d to blocks %d to %d", i + 1, j, j + fileSize - 1);
                    break;
                }
                else
                {
                    int m;
                    // If not enough space, clear previous allocations
                    for (m = j; m < j + count; m++)
                    {
                        blocks[m] = 0;
                    }
                }
            }
        }
    }
}

int main()
{
    int blocks[MAX_BLOCKS] = {0};         // 0 means block is free, non-zero means allocated
    int fileSizes[MAX_FILES] = {3, 4, 2}; // File sizes to allocate

    contiguousAllocation(blocks, fileSizes, MAX_FILES);

    printf("\n� 2025 Pitam. All rights reserved.\n");

    return 0;
}
