#include <stdio.h>

int main()
{
    int n, i;
    printf("Enter the number of processes: ");
    scanf("%d", &n);

    int arrivalTime[n], burstTime[n], waitingTime[n], turnAroundTime[n];
    float totalWait = 0, totalTurnAround = 0;

    printf("Enter Arrival Time and Burst Time for each process:\n");
    for (i = 0; i < n; i++)
    {
        printf("Process %d (Arrival, Burst): ", i + 1);
        scanf("%d %d", &arrivalTime[i], &burstTime[i]);
    }

    // Calculate waiting and turnaround times
    waitingTime[0] = 0; // First process starts immediately
    for (i = 1; i < n; i++)
    {
        waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1] - (arrivalTime[i] - arrivalTime[i - 1]);
        if (waitingTime[i] < 0)
            waitingTime[i] = 0; // Ensure non-negative waiting time
    }

    for (i = 0; i < n; i++)
    {
        turnAroundTime[i] = waitingTime[i] + burstTime[i];
        totalWait += waitingTime[i];
        totalTurnAround += turnAroundTime[i];
    }

    // Display results
    printf("\nProcess\tArrival\tBurst\tWaiting\tTurnaround\n");
    for (i = 0; i < n; i++)
    {
        printf("P%d\t%d\t%d\t%d\t%d\n", i + 1, arrivalTime[i], burstTime[i], waitingTime[i], turnAroundTime[i]);
    }

    printf("\nAverage Waiting Time: %.2f", totalWait / n);
    printf("\nAverage Turnaround Time: %.2f", totalTurnAround / n);

    // Copyright
    printf("\n\n© 2025 Pitam. All rights reserved.\n");

    return 0;
}
