#include <stdio.h>
#include <stdlib.h>
#include <math.h>
void fcfs(int requests[], int n, int head)
{
    int seek_time = 0, i;
    printf("\nFCFS Disk Scheduling:\n");
    printf("Seek Sequence: %d -> ", head);
    for (i = 0; i < n; i++)
    {
        seek_time += abs(requests[i] - head);
        printf("%d -> ", requests[i]);
        head = requests[i];
    }
    printf("\nTotal Seek Time: %d\n", seek_time);

    printf("Average Seek Time: %.2f\n", (float)seek_time / n);
}
void sstf(int requests[], int n, int head)
{
    int seek_time = 0, completed = 0;
    int visited[n], min_seek, pos, i;
    for (i = 0; i < n; i++)
        visited[i] = 0;
    printf("\nSSTF Disk Scheduling:\n");
    printf("Seek Sequence: %d -> ", head);
    while (completed < n)
    {
        min_seek = 10000; // Large number for comparison
        pos = -1;
        for (i = 0; i < n; i++)
        {
            if (!visited[i] && abs(requests[i] - head) < min_seek)
            {
                min_seek = abs(requests[i] - head);
                pos = i;
            }
        }
        seek_time += min_seek;
        visited[pos] = 1;
        head = requests[pos];
        completed++;
        printf("%d -> ", head);
    }
    printf("\nTotal Seek Time: %d\n", seek_time);
    printf("Average Seek Time: %.2f\n", (float)seek_time / n);
}
void scan(int requests[], int n, int head, int disk_size, int direction)
{
    int seek_time = 0, i, pos;
    int sorted[n + 1];

    for (i = 0; i < n; i++)
        sorted[i] = requests[i];
    sorted[n] = (direction == 1) ? disk_size - 1 : 0;
    // Sort the requests including the boundary
    for (i = 0; i < n; i++)
    {
        int j;
        for (j = i + 1; j <= n; j++)
        {
            if (sorted[i] > sorted[j])
            {
                int temp = sorted[i];
                sorted[i] = sorted[j];
                sorted[j] = temp;
            }
        }
    }
    // Find position of the head
    for (i = 0; i <= n; i++)
    {
        if (head < sorted[i])
        {
            pos = i;
            break;
        }
    }
    printf("\nSCAN Disk Scheduling:\n");
    printf("Seek Sequence: %d -> ", head);
    if (direction == 1)
    { // Move towards the right
        for (i = pos; i <= n; i++)
        {
            seek_time += abs(sorted[i] - head);
            head = sorted[i];
            printf("%d -> ", head);
        }
        for (i = pos - 1; i >= 0; i--)
        {
            seek_time += abs(sorted[i] - head);
            head = sorted[i];
            printf("%d -> ", head);
        }
    }
    else
    { // Move towards the left

        for (i = pos - 1; i >= 0; i--)
        {
            seek_time += abs(sorted[i] - head);
            head = sorted[i];
            printf("%d -> ", head);
        }
        for (i = pos; i <= n; i++)
        {
            seek_time += abs(sorted[i] - head);
            head = sorted[i];
            printf("%d -> ", head);
        }
    }
    printf("\nTotal Seek Time: %d\n", seek_time);
    printf("Average Seek Time: %.2f\n", (float)seek_time / n);
}
int main()
{
    int n, head, disk_size, direction, i;
    printf("Enter number of requests: ");
    scanf("%d", &n);
    int requests[n];
    printf("Enter the requests: ");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &requests[i]);
    }
    printf("Enter initial head position: ");
    scanf("%d", &head);
    printf("Enter disk size: ");
    scanf("%d", &disk_size);
    printf("Enter direction (1 for high, 0 for low): ");
    scanf("%d", &direction);

    fcfs(requests, n, head);
    sstf(requests, n, head);
    scan(requests, n, head, disk_size, direction);
    return 0;
}
