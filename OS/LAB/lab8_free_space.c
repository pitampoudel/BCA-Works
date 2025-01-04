#include <stdio.h>
#include <stdlib.h>
#define TOTAL_BLOCKS 32

void displayBitVector(int bitVector[])
{
    int i;
    for (i = 0; i < TOTAL_BLOCKS; i++)
    {
        printf("%d ", bitVector[i]);
    }
    printf("\n");
}

typedef struct FreeBlock
{
    int start;
    int size;
    struct FreeBlock *next;
} FreeBlock;

void displayFreeBlocks(FreeBlock *head)
{
    FreeBlock *temp = head;
    while (temp != NULL)
    {
        printf("Start: %d, Size: %d\n", temp->start, temp->size);
        temp = temp->next;
    }
}

int main()
{
    // Q1.Demonstrate free space management using Bit Vector technique.

    int bitVector[TOTAL_BLOCKS] = {0}; // Initialize all blocks as free
    // Allocating some blocks
    bitVector[3] = 1;
    bitVector[7] = 1;
    bitVector[12] = 1;
    printf("Bit Vector Representation:\n");
    displayBitVector(bitVector);

    // Q2.Demonstrate free space management using Linked List technique.
    FreeBlock *head = (FreeBlock *)malloc(sizeof(FreeBlock));
    head->start = 0;
    head->size = 10;
    head->next = NULL;
    FreeBlock *second = (FreeBlock *)malloc(sizeof(FreeBlock));
    second->start = 20;
    second->size = 15;
    second->next = NULL;
    head->next = second;
    printf("Free Block List:\n");
    displayFreeBlocks(head);
    printf("\n© 2025 Pitam. All rights reserved.\n");

    return 0;
}
