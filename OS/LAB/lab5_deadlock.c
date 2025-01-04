#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
// Number of processes and resources
#define PROCESSES 5
#define RESOURCES 3
// Function to allocate resources to a process
bool allocateResources(int process, int request[], int available[], int allocation[PROCESSES][RESOURCES])
{
	int i = 0;
    // Check if resources are available
    for ( i = 0; i < RESOURCES; i++)
    {
        if (request[i] > available[i])
        {
            printf("Request denied: Not enough resources available.\n");
            return false;
        }
    }
    // Allocate resources
    for ( i = 0; i < RESOURCES; i++)
    {
        available[i] -= request[i];
        allocation[process][i] += request[i];
    }
    printf("Request granted.\n");
    return true;
}
// Main function
int main()
{
	int i =0;
    // Available resources
    int available[RESOURCES] = {10, 5, 7};

    // Allocation matrix
    int allocation[PROCESSES][RESOURCES] = {0};
    // Example resource requests
    int request1[RESOURCES] = {3, 2, 2};
    int request2[RESOURCES] = {1, 0, 3};
    // Process 1 requests resources
    allocateResources(1, request1, available, allocation);
    // Process 2 requests resources
    allocateResources(2, request2, available, allocation);
    // Display current resource allocation
    printf("Current resource allocation:\n");
    for ( i = 0; i < PROCESSES; i++)
    {
    	int j;
        printf("Process %d: ", i);
        for ( j = 0; j < RESOURCES; j++)
        {
            printf("%d ", allocation[i][j]);
        }
        printf("\n");
    }
    return 0;
}
