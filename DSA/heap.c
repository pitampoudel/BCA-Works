#include <stdio.h>
#include <stdlib.h>

#define MAX 100

struct MaxHeap
{
    int size;
    int array[MAX];
};

// Function to create a max heap
struct MaxHeap *createMaxHeap()
{
    struct MaxHeap *maxHeap = (struct MaxHeap *)malloc(sizeof(struct MaxHeap));
    maxHeap->size = 0;
    return maxHeap;
}

// Function to swap two elements
void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

// Function to heapify up (used after insertion)
void heapifyUp(struct MaxHeap *maxHeap, int index)
{
    int parent = (index - 1) / 2;

    if (index > 0 && maxHeap->array[index] > maxHeap->array[parent])
    {
        swap(&maxHeap->array[index], &maxHeap->array[parent]);
        heapifyUp(maxHeap, parent);
    }
}

// Function to insert an element into the heap
void insert(struct MaxHeap *maxHeap, int value)
{
    if (maxHeap->size == MAX)
    {
        printf("Heap is full\n");
        return;
    }

    maxHeap->array[maxHeap->size] = value;
    maxHeap->size++;
    heapifyUp(maxHeap, maxHeap->size - 1);
}

// Function to heapify down (used after deletion)
void heapifyDown(struct MaxHeap *maxHeap, int index)
{
    int leftChild = 2 * index + 1;
    int rightChild = 2 * index + 2;
    int largest = index;

    if (leftChild < maxHeap->size && maxHeap->array[leftChild] > maxHeap->array[largest])
    {
        largest = leftChild;
    }

    if (rightChild < maxHeap->size && maxHeap->array[rightChild] > maxHeap->array[largest])
    {
        largest = rightChild;
    }

    if (largest != index)
    {
        swap(&maxHeap->array[index], &maxHeap->array[largest]);
        heapifyDown(maxHeap, largest);
    }
}

// Function to delete the root element from the heap
int deleteRoot(struct MaxHeap *maxHeap)
{
    if (maxHeap->size == 0)
    {
        printf("Heap is empty\n");
        return -1;
    }

    int rootValue = maxHeap->array[0];
    maxHeap->array[0] = maxHeap->array[maxHeap->size - 1];
    maxHeap->size--;
    heapifyDown(maxHeap, 0);

    return rootValue;
}

// Function to print the heap
void printHeap(struct MaxHeap *maxHeap)
{
	int i;
    for ( i = 0; i < maxHeap->size; i++)
    {
        printf("%d ", maxHeap->array[i]);
    }
    printf("\n");
}

int main()
{
    struct MaxHeap *maxHeap = createMaxHeap();

    insert(maxHeap, 10);
    insert(maxHeap, 20);
    insert(maxHeap, 30);
    insert(maxHeap, 25);
    insert(maxHeap, 5);
    insert(maxHeap, 40);

    printf("Heap after insertion: ");
    printHeap(maxHeap);

    printf("Deleted root: %d\n", deleteRoot(maxHeap));
    printf("Heap after deletion: ");
    printHeap(maxHeap);

    free(maxHeap);
    printf("© Copyright Pitam Poudel. All Rights Reserved");
    return 0;
}
